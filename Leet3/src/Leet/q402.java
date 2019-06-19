package Leet;

import java.util.*;

/*
 * �����iλ������С�ڵ�i-1λ�����֣���ôɾ����i-1λ�����֣���С�ڣ���ɾ��
 * 1999732->199732->19732->1732->132->12->1
 * 1023400->023400->02300->0200->000
 * ������ջ��һֱ���������������ˡ�����ջ�ﱣ��ļ�ɾ��Ľ������Ҫ������˳��ȥ�������0��
 * ���ûɾ�������������ɾֱ��ɾ������
 */

public class q402 {
	public String removeKdigits(String num, int k) {
		if(k>=num.length()||num.length()==0)	return "0";
		StringBuilder s=new StringBuilder();
		Stack<Character> stk=new Stack<Character>();
		Stack<Character> helpstk=new Stack<Character>();
		stk.push(num.charAt(0));
		int count=0;
		for(int i=1;i<num.length();i++) {
			char cur=num.charAt(i);
			while(!stk.isEmpty()&&stk.peek()>cur&&count<k) {
				stk.pop();
				count++;
			}
			stk.push(cur);
		}
		while(!stk.isEmpty()) {
			helpstk.push(stk.pop());
		}
		while(!helpstk.isEmpty()) {
			s.append(helpstk.pop());
		}
		num=s.toString();
		for(int i=0;i<num.length();i++) {
			if(num.charAt(i)!='0')
				return num.substring(i,num.length()-k+count);
		}
		return "0";
    }
}
