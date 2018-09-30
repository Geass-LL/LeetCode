package Leet;

import java.util.Stack;
/*
 * �Ƚϼ򵥣��õ��Ƕ�ջ���뷨������Ҫ���ǵ������Ұ����ź��������ʣ��������
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
