package Main;

import java.util.*;

public class Bit2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		Stack<String> stk=new Stack<String>();
		char[] chs=s.toCharArray();
		String cur="";
		int curnum=0;
		for(int i=0;i<chs.length;i++) {
			char ch=chs[i];
			if(ch<='9' && ch>='0') {
				curnum=curnum*10+ch-'0';
				stk.push(cur);
				cur="";
			}else if(ch=='%') {
				stk.push(String.valueOf(curnum));
				curnum=0;
			}else if(ch=='#') {
				if(cur.length()>0)	stk.push(cur);
				String temp=stk.pop(),nowtemp="";
				int tempi=Integer.valueOf(stk.pop());
				for(int j=0;j<tempi;j++) {
					nowtemp+=temp;
				}
				stk.push(stk.pop()+nowtemp);
				cur="";
			}else {
				cur+=ch;
			}
		}
		String res="";
		Stack<String> temp=new Stack<String>();
		while(!stk.isEmpty()) {
			temp.push(stk.pop());
		}
		while(!temp.isEmpty()) {
			res+=temp.pop();
		}
		System.out.println(res);
	}
}
