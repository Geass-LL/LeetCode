package Leet;

/*
 * 感觉可以当成一个Easy来做，记录每个位置能够到达的最远位置，如果0的位置大于或者等于最远位置则返回false；
 * 注意如果最远位置到了终点，终点是0，要返回的是true。
 */
public class q55 {
	public boolean canJump(int[] nums) {
		int maxpos=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) {
				maxpos=Math.max(maxpos, nums[i]+i);
			}else {
				if(maxpos<=i&&i!=nums.length-1)
					return false;
			}
		}
		return true;
    }
}
