package Leet;

/*
 * 思路：
 * 分两种情况，res0表示强制不偷第一家，res1表示强制偷第一家；
 * res[i]表示在必定偷第i家时最大值，它又分两种情况：
 * 1、第i-1家偷了：现在不偷第i-1家，改偷第i家；
 * 2、第i-1家没偷：现在直接偷第i家；
 * 最后的结果应该是所有四种结果之最大值。原因是不可能放着不偷呀。
 */

public class q213 {
	public int rob(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		if(nums.length==2) return Math.max(nums[0], nums[1]);
		if(nums.length==3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
		int[] res0=new int[nums.length],res1=new int[nums.length];
		res0[0]=0;
		res0[1]=nums[1];
		for(int i=2;i<nums.length;i++) {
			res0[i]=Math.max(nums[i]+res0[i-2], res0[i-1]-nums[i-1]+nums[i]);
		}
		res1[0]=nums[0];
		res1[1]=nums[1];
		for(int i=2;i<nums.length-1;i++) {
			res1[i]=Math.max(nums[i]+res1[i-2], res1[i-1]-nums[i-1]+nums[i]);
		}
		return Math.max(Math.max(res0[nums.length-1], res0[nums.length-2]), 
						Math.max(res1[nums.length-2], res1[nums.length-3]));
    }
}
