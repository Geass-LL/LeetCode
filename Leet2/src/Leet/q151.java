package Leet;

/*
 * change函数是把字符数组从start到end为止做一个反转，当然其中的空格也进行了反转：
 * “##the##sky#is###blue###”反转为：“###eulb###si#yks##eht##”
 * 再次反转，反转的同时将空格全部移到最后。
 * 反转的起始值为第一次为0，后面为有效长度+1（为的是和前面预留一个空格）；反转的终止值为满足当前为非空格，但是下一字符为空格的位置；
 * 有效长度在每遇到一个非空格值时加1，在反转后，因为加了单词间隔的空格，额外加1.
 * 第一次反转：反转前：val=4,left=0,end=3；反转后：“blue######si#yks##eht##”,val=5
 * 第二次反转：反转前：val=7,left=5,end=11；反转后：“blue#is#######yks##eht##”,val=8
 */

public class q151 {
	public String reverseWords(String s) {
		char[] str=s.toCharArray();
		int length=str.length;
		change(str,0,length-1);
		int val=0,left=0,right=0;
		while(right<length) {
			if(str[right]!=' ') {
				val++;
				if(right>=length-1||str[right+1]==' ') {
					change(str,left,right);
					left=++val;
				}
			}
			right++;
		}
		if(val==0) return "";
		else return String.valueOf(str).substring(0, val-1);
    }
	void change(char[] str,int start,int end) {
		while(start<end) {
			char temp=str[start];
			str[start++]=str[end];
			str[end--]=temp;
		}
	}
}
