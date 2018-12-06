package Leet;

/*
 * change�����ǰ��ַ������start��endΪֹ��һ����ת����Ȼ���еĿո�Ҳ�����˷�ת��
 * ��##the##sky#is###blue###����תΪ����###eulb###si#yks##eht##��
 * �ٴη�ת����ת��ͬʱ���ո�ȫ���Ƶ����
 * ��ת����ʼֵΪ��һ��Ϊ0������Ϊ��Ч����+1��Ϊ���Ǻ�ǰ��Ԥ��һ���ո񣩣���ת����ֵֹΪ���㵱ǰΪ�ǿո񣬵�����һ�ַ�Ϊ�ո��λ�ã�
 * ��Ч������ÿ����һ���ǿո�ֵʱ��1���ڷ�ת����Ϊ���˵��ʼ���Ŀո񣬶����1.
 * ��һ�η�ת����תǰ��val=4,left=0,end=3����ת�󣺡�blue######si#yks##eht##��,val=5
 * �ڶ��η�ת����תǰ��val=7,left=5,end=11����ת�󣺡�blue#is#######yks##eht##��,val=8
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
