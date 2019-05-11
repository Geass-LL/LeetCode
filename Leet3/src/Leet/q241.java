package Leet;

import java.util.*;

/*
 * 一直递归的解法，速度有些慢，涉及了很多重复的运算，当然如果采用动态规划的方法是可行的，但是有点儿难写。
 * 解法其实很简单：分治法。
 */

public class q241 {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> nums=new ArrayList<Integer>();
		List<Character> ops=new ArrayList<Character>();
		int cur=0;
		for(int i=0;i<input.length();i++) {
			char ch=input.charAt(i);
			if(ch<='9'&&ch>='0') {
				cur=cur*10+ch-'0';
			}else if(ch=='-'||ch=='+'||ch=='*') {
				nums.add(cur);
				ops.add(ch);
				cur=0;
			}
		}
		nums.add(cur);
		return help(nums,ops);
    }
	List<Integer> help(List<Integer> nums,List<Character> ops){
		List<Integer> res=new ArrayList<Integer>();
		if(nums.size()==1) {
			return nums;
		}else if(nums.size()==2) {
			if(ops.get(0)=='-') {
				res.add(nums.get(0)-nums.get(1));
			}else if(ops.get(0)=='+') {
				res.add(nums.get(0)+nums.get(1));
			}else if(ops.get(0)=='*') {
				res.add(nums.get(0)*nums.get(1));
			}
			return res;
		}else {
			List<Integer> right0=help(nums.subList(1, nums.size()),ops.subList(1, ops.size()));
			for(int i=0;i<right0.size();i++) {
				if(ops.get(0)=='-') right0.set(i, nums.get(0)-right0.get(i));
				else if(ops.get(0)=='+') right0.set(i, nums.get(0)+right0.get(i));
				else if(ops.get(0)=='*') right0.set(i, nums.get(0)*right0.get(i));
			}
			res.addAll(right0);
			for(int i=1;i<ops.size()-1;i++) {
				List<Integer> left=help(nums.subList(0, i+1),ops.subList(0, i));
				List<Integer> right=help(nums.subList(i+1, nums.size()),ops.subList(i+1, ops.size()));
				for(int j=0;j<left.size();j++) {
					for(int k=0;k<right.size();k++) {
						if(ops.get(i)=='-')	res.add(left.get(j)-right.get(k));
						else if(ops.get(i)=='+') res.add(left.get(j)+right.get(k));
						else if(ops.get(i)=='*') res.add(left.get(j)*right.get(k));
					}
				}
			}
			List<Integer> left0=help(nums.subList(0, nums.size()-1),ops.subList(0, ops.size()-1));
			for(int i=0;i<left0.size();i++) {
				if(ops.get(ops.size()-1)=='-') left0.set(i, left0.get(i)-nums.get(nums.size()-1));
				else if(ops.get(ops.size()-1)=='+') left0.set(i, left0.get(i)+nums.get(nums.size()-1));
				else if(ops.get(ops.size()-1)=='*') left0.set(i, left0.get(i)*nums.get(nums.size()-1));
			}
			res.addAll(left0);
			return res;
		}
	}
}
