package Leet;

/*
 * 思路：
 * 无论如何，对称部分最右侧应该同第一个char相同。
 * 取第0个char为target，从i=1开始，找字符为target的；
 * 如果找到：target到当前位置是否完全对称，有一处不对称则取消，完全对称则记录当前位置right；
 * 从记录的right开始补全。
 */

public class q214 {
	public String shortestPalindrome(String s) {
		if(s==null||s.length()==0) return "";
		if(s.length()==1) return s;
		char[] chs=s.toCharArray();
		char target=chs[0];//取第0个char为target，
		int right=0;//right初始化为0
		for(int i=1;i<chs.length;i++) {//从i=1开始，找字符为target的；
			if(chs[i]==target) {//找字符为target的，如果找到：
				int j=1;
				while(j<=i-j) {//target到当前位置是否完全对称，
					if(chs[j]!=chs[i-j])	break;//有一处不对称则取消
					j++;
				}
				if(j>i-j)	right=i;//完全对称则记录当前位置right；
			}
		}
		String res="";
		for(int i=chs.length-1;i>right;i--) {
			res+=chs[i];//从记录的right开始补全。
		}
		return res+=s;
    }
}
