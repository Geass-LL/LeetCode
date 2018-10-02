package Leet;

import java.util.*;
/*
 * 方法：遍历，然后再根据之前判断是否有效的方法。效率及其低下了。
 */
public class q22 {
	public List<String> generateParenthesis(int n) {
		List<String> res=new ArrayList();
        String temp="";
		backtrack(temp,0,res,2*n);
		for(String eachres:res) {
			System.out.println(eachres);
		}
		return res;
    }
	void backtrack(String cur,int k,List<String> res,int finish){
		if(k==finish) {
			if(isValid(cur))
				res.add(cur);
		}else {
			k++;
			String[] candidates= {"(",")"};
			for (int i=0;i<candidates.length;i++) {
				cur+=candidates[i];
				backtrack(cur,k,res,finish);
				cur=cur.substring(0, cur.length()-1);
			}
		}
	}
	boolean isValid(String s) {
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
