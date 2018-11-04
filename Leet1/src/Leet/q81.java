package Leet;

/*
 * 大神的思路真的简单明了啊，学习了。作图见Onenote。
 */

public class q81 {
	public boolean search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
        	int mid=(left+right)/2;
        	if(nums[mid]==target) {
        		return true;
        	}else if(nums[mid]>nums[left]) {
        		if(nums[mid]>target&&nums[left]<=target) {
        			right=mid-1;
        		}else {
        			left=mid+1;
        		}
        	}else if(nums[mid]<nums[left]) {
        		if(nums[mid]<target&&nums[right]>=target) {
        			left=mid+1;
        		}else {
        			right=mid-1;
        		}
        	}else {
        		left++;
        	}
        }
        return false;
    }
}
