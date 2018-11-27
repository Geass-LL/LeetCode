package Leet;

import java.util.Arrays;

public class q137_sort {
	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int i;
		for(i=0;i<nums.length-1;i+=3) {
			if(nums[i]!=nums[i+1]) break;
		}
		return nums[i];
    }
}
