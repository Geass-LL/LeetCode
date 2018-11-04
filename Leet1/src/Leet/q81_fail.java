package Leet;

import java.util.Arrays;

/*
 * 思路：先找到转折点，再分两个进行二分查找；但是最后一个全为1，中间夹杂着一个2的测试例没有通过，实在不知道改怎么修改了。
 */

public class q81_fail {
	public boolean search(int[] nums, int target) {
		if(nums.length==0||nums==null)
			return false;
		int numsboundry=boundry(nums);
		System.out.println(numsboundry);
		return (bisearch(Arrays.copyOfRange(nums, 0, numsboundry+1),target)||
				bisearch(Arrays.copyOfRange(nums, numsboundry, nums.length),target));
    }
	boolean bisearch(int[] nums,int target) {
		int mid=0,left=0,right=nums.length-1;
		while(left<=right) {
			mid=(left+right)/2;
			if(nums[mid]<target) {
				left=mid+1;
			}else if(nums[mid]>target) {
				right=mid-1;
			}else {
				return true;
			}
		}
		return false;
	}
	int boundry(int[] nums) {
		int left=0,right=nums.length-1,mid=0;
		while(left<=right) {
			mid=(left+right)/2;
			if(mid==0) {
				if(nums.length>1&&nums[mid+1]<nums[mid]) {
					return mid+1;
				}else {
					return mid;
				}
			}
            if(mid==nums.length-1||(nums[mid]<=nums[mid+1]&&nums[mid]<nums[mid-1]))
				return mid;
			if(nums[mid]>nums[nums.length-1]) {
				left=mid+1;
			}else if(nums[mid]<nums[0]) {
				right=mid-1;
			}else{
                if(nums[mid-1]<nums[mid])
                    return mid-1;
                else
                    return mid;
            }
		}
        return mid;
	}
}
