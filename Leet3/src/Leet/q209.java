package Leet;

import java.util.Arrays;

public class q209 {
	/*
	public int minSubArrayLen(int s, int[] nums) {
		if(nums==null) return 0;
		int left=0,right=0,sum=0,res=nums.length+1;
		while(right<nums.length) {
			if(nums[right]>s) {
				right++;
				left=right;
				sum=0;
			}
			if(sum<s) {
				sum+=nums[right++];
			}else if(sum>s) {
				sum-=nums[left++];
			}
			while(sum==s) {
				res=Math.min(res, right-left);
				sum-=nums[left++];
			}
		}
		while(left<=right&&sum>s) {
			sum-=nums[left++];
			while(sum==s) {
				res=Math.min(res, right-left);
				sum-=nums[left++];
			}
		}
		return res>nums.length?0:res;
	}
	*/
	/*
	public int minSubArrayLen(int s,int[] nums) {
		if(nums==null) return 0;
		int sum=0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
		}
		if(sum<s) return 0;
		int left=0,right=nums.length-1;
		while(left<right&&sum>s) {
			//System.out.println(String.valueOf(sum)+","+String.valueOf(left)+","+String.valueOf(right));
			if(nums[left]<nums[right]) {
				sum-=nums[left++];
			}else if(nums[left]>nums[right]) {
				sum-=nums[right--];
			}else {
				int templeft=left+1,tempright=right-1;
				while(templeft<=tempright&&nums[templeft]==nums[tempright]) {
					templeft++;
					tempright--;
				}
				if(nums[templeft]<nums[tempright]) {
					sum-=nums[left++];
				}else {
					sum-=nums[right--];
				}
			}
		}
		if(sum<s) return right-left+2;
		while(left<right&&sum==s) {
			if(nums[left]!=0&&nums[right]!=0) break;
			if(nums[left]==0) left++;
			if(nums[right]==0) right--;
		}
		return right-left+1;
	}*/
	public int minSubArrayLen(int s,int[] nums) {
		if(nums==null||nums.length==0) return 0;
		int res=nums.length+1;
		int left=0,sum=0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			while(sum>=s) {
				res=Math.min(res, i-left+1);
				sum-=nums[left++];
			}
		}
		return (res==nums.length-1)?0:res;
	}
}
