package Leet;

import java.util.Arrays;

public class q215 {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length-k];
    }
}
