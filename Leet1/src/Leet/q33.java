package Leet;

import java.util.Arrays;

/*
 * 我的天哪，打了一晚上补丁。。。
 * 原理很简单，见Onenote
 */
public class q33 {
	public int  search(int[] nums, int target) {
		int left=0;
		int right=nums.length-1;
		int mid=(left+right)/2;
		if(nums.length==0||nums==null) {
			return -1;
		}else if(nums.length<=2) {
			for(int i=0;i<nums.length;i++) {
				if (nums[i]==target)
					return i;
			}
			return -1;
		}
		if(nums[mid]==target) {
			return mid;
		}else if(nums[mid]<=nums[left]&&nums[mid]<=nums[right]) {
			if(target<=nums[right]&&target>=nums[mid])
				return change(mid,bisearch(Arrays.copyOfRange(nums, mid, right+1),target));
			else
				return change(left,search(Arrays.copyOfRange(nums, left, mid),target));
		}else if(nums[mid]>=nums[left]&&nums[mid]>=nums[right]){
			if(target<=nums[mid]&&target>=nums[left])
				return change(left,bisearch(Arrays.copyOfRange(nums, left, mid),target));
			else
				return change(mid,search(Arrays.copyOfRange(nums, mid, right+1),target));
		}else {
			return bisearch(Arrays.copyOfRange(nums, left, right+1),target);
		}
	}
	int bisearch(int[] nums,int target) {
		int left=0;
		int right=nums.length-1;
		while(left<=right) {
			int mid=(left+right)/2;
			if(nums[mid]<target)
				left=mid+1;
			else if(nums[mid]==target)
				return mid;
			else
				right=mid-1;
		}
		return -1;
	}
	int change(int num1,int num) {
		if (num==-1) {
			return -1;
		}else {
			return num1+num;
		}
	}
}
