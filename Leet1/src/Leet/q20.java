package Leet;

import java.util.Stack;
/*
 * 比较简单，用的是堆栈的想法。但是要考虑到多了右半括号和左半括号剩余的情况。
 */
public class q20 {
	public boolean isValid(String s) {
		Stack<Character> st= new Stack<Character>();
		for (int i=0;i<s.length();i++) {
			char cur=s.charAt(i);
			if(cur=='(' || cur=='[' || cur=='{') {
				st.push(cur);
			}else if(cur==')' || cur==']' || cur=='}') {
				if(st.empty()) {
					return false;
				}else {
					char prev=st.pop();
					if((prev=='(' && cur==')')||(prev=='[' && cur==']')||(prev=='{' && cur=='}')) {
						continue;
					}else {
						return false;
					}
				}
			}
		}
		if(st.empty()) {
			return true;
		}else {
			return false;
		}
    }
}
