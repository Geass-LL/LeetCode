package Leet;

import java.util.*;
/*
 * �Ƚϼ򵥣������77�⣬ȥ���˶Խ�ĺ����Ե���֤��
 */
public class q78 {
	 public List<List<Integer>> subsets(int[] nums) {
		 List<List<Integer>> res=new ArrayList<List<Integer>>();
		 btk(res,new ArrayList(),nums,0);
		 return res;
	 }
	 void btk(List<List<Integer>> res,List<Integer> temp,int[] nums,int deep) {
		 res.add(new ArrayList(temp));
		 for(int i=deep;i<nums.length;i++) {
			 temp.add(nums[i]);
			 btk(res,temp,nums,i+1);
			 temp.remove(temp.size()-1);
		 }
	 }
}
