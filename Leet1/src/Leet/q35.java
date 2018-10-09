package Leet;
/*
 * Easy, Find the value, if not found, compare this value with nums[mid];
 * if bigger than nums[mid], return mid+1;
 * else return mid, replace nums[mid] with this value.
 */
public class q35 {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid=(left+right)/2;
        while(left<=right) {
        	mid=(left+right)/2;
        	if(nums[mid]==target) {
        		return mid;
        	}else if(nums[mid]<target){
        		left=mid+1;
        	}else {
        		right=mid-1;
        	}
        }
        if(target>nums[mid]) {
        	return mid+1;
        }else {
        	return mid;
        }
    }
}
