package Leet;

import java.util.*;

/*
 * 先排序，再利用类似q47的方法去重。注意，必须排序，否则会出现问题。
 */

public class q90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int[] cho=new int[nums.length];
		dyp(res,new ArrayList<Integer>(),nums,cho,0);
		return res;
    }
	void dyp(List<List<Integer>> res,List<Integer> temp,int[] nums,int[] cho,int deep) {
		res.add(new ArrayList(temp));
		for(int i=deep;i<nums.length;i++) {
			if(i>0&&nums[i]==nums[i-1]&&cho[i-1]==0) continue;
			//这句话的意思：
			//如果想动用第二个重复数字，那么第一个重复数字必须已经使用过。所以这就要求排序。
			temp.add(nums[i]);
			cho[i]=1;
			dyp(res,temp,nums,cho,i+1);
			cho[i]=0;
			temp.remove(temp.size()-1);
		}
	}
}
