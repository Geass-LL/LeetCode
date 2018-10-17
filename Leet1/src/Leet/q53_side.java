package Leet;
/*
 * mad，简单题，Leetcode诚不我欺。
 * 单边走更简单呀。如果当前值加上之前的和小于当前值，把和修改为当前值；否则，之前的和加上当前值。每次都记录下最大和。
 */
public class q53_side {
	public int maxSubArray(int[] nums) {
		int sum=nums[0];
		int maxsum=sum;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]+sum<nums[i])
				sum=nums[i];
			else
				sum+=nums[i];
			if(sum>maxsum)
				maxsum=sum;
		}
		return maxsum;
	}
}
