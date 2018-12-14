package Leet;

public class q153 {
	public int findMin(int[] nums) {
		int length=nums.length;
		int left=0,right=length-1,res=0;
		while(left+1<right) {
			int mid=(left+right)/2;
			if(nums[mid]<nums[0]&&nums[mid]<nums[length-1]) {
				right=mid;
			}else if(nums[mid]>nums[0]&&nums[mid]>nums[length-1]) {
				left=mid;
			}else if(nums[mid]>nums[0]) {
				right=mid;
			}else {
				left=mid;
			}
		}
		return Math.min(nums[left], nums[right]);
    }
}
