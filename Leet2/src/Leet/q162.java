package Leet;

/*
 * 没按照题目要求做出对数的结果，但是accept了。
 */

public class q162 {
	public int findPeakElement(int[] nums) {
		if(nums==null||nums.length<=1) return 0;
		for(int i=1;i<nums.length-1;i++) {
			if(nums[i]>nums[i+1]&&nums[i]>nums[i-1])
				return i;
		}
		if(nums[nums.length-1]>nums[nums.length-2]) {
			return nums.length-1;
		}
		return 0;
    }
}
