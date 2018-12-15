package Leet;

/*没什么好说的，直接看代码吧。
 * 参考onenote Leetcode81可解。
 * */

public class q154 {
	public int findMin(int[] nums) {
		int length=nums.length;
		int left=0,right=length-1,res=Math.min(nums[left], nums[right]);
		while(left<=right) {
			int mid=(left+right)/2;
			int tempres=Math.min(nums[left], nums[right]);
			if(tempres<res) res=tempres;
			if(nums[left]==nums[mid]) {
				left++;
			}else if(nums[right]==nums[mid]) {
				right--;
			}else if(nums[mid]>nums[left]) {
				left=mid;
			}else if(nums[mid]<nums[right]) {
				right=mid;
			}else {
				System.out.println("I dont know!!!");
			}
		}
		return res;
    }
}
