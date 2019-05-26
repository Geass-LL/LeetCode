package Main;

import java.util.*;

public class Cal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		map.put('+',1);
		map.put('-',1);
		map.put('*',2);
		map.put('/',2);
		map.put('(',0);
		String s="((1+2)*3)/4";
		System.out.println(cal(map,s));
	}
	static String cal(Map<Character,Integer> map,String s) {
		String res="";
		char[] chs=s.toCharArray();
		Stack<Character> stk=new Stack<Character>();
		for(int i=0;i<chs.length;i++) {
			char ch=chs[i];
			if(ch<='9'&&ch>='0') {
				res+=ch;
			}else if(ch=='(') {
				stk.push(ch);
			}else if(ch==')') {
				while(!stk.isEmpty()) {
					if(stk.peek()!='(') {
						res+=stk.pop();
					}else {
						stk.pop();
					}
				}
			}else {
				if(stk.isEmpty()) {
					stk.push(ch);
				}else {
					while(!stk.isEmpty()) {
						char op=stk.peek();
						if(map.get(op)<ch) {
							stk.push(ch);
							break;
						}else {
							res+=stk.pop();
						}
					}
				}
			}
		}
		while(!stk.isEmpty())	res+=stk.pop();
		return res;
	}
}
