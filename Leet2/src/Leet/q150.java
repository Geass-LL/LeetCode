package Leet;

import java.util.*;

public class q150 {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack=new Stack<Integer>();
		for(String eachstr:tokens) {
			if(eachstr.equals("+")) {
				int num2=stack.pop(),num1=stack.pop();
				stack.push(num1+num2);
			}else if(eachstr.equals("-")) {
				int num2=stack.pop(),num1=stack.pop();
				stack.push(num1-num2);
			}else if(eachstr.equals("*")) {
				int num2=stack.pop(),num1=stack.pop();
				stack.push(num1*num2);
			}else if(eachstr.equals("/")) {
				int num2=stack.pop(),num1=stack.pop();
				stack.push(num1/num2);
			}else {
				stack.push(Integer.valueOf(eachstr));
			}
		}
		return stack.pop();
    }
}
