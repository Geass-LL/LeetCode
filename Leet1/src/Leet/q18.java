package Leet;

import java.lang.reflect.Array;
import java.util.*;

/*
 *         for (int i=0;i<nums.length-1;i++) {
        	if(i>0 && nums[i]==nums[i-1]) {
        		continue;
        	}
        	int target3sum=target-nums[i];
        	for (int j=i+1;j<nums.length;j++) {
        		if (j>i+1 && nums[j]==nums[j-1]) {
        			continue;
        		}
       		如何结合上3sum结束这个问题，
       		在3sum外再加一层循环；
 */
public class q18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++) {
        	if(i>0 && nums[i]==nums[i-1]) {
        		continue;
        	}
        	int target3sum=target-nums[i];
        	for (int j=i+1;j<nums.length;j++) {
        		if (j>i+1 && nums[j]==nums[j-1]) {
        			continue;
        		}
        		int left=j+1,right=nums.length-1;
        		int target2sum=target3sum-nums[j];
        		while(left<right) {
        			if(nums[left]+nums[right]==target2sum) {
        				List<Integer> temp=new ArrayList();
        				temp.add(nums[i]);
        				temp.add(nums[j]);
        				temp.add(nums[left]);
        				temp.add(nums[right]);
        				res.add(temp);
        				while(left<right && nums[left]==nums[++left]) {}
        				while(left<right && nums[right]==nums[--right]) {}
        			}
        			else if(nums[left]+nums[right]<target2sum) {
        				while(left<right && nums[left]==nums[++left]) {}
        			}else {
        				while(left<right && nums[right]==nums[--right]) {}
        			}
        		}
        	}
        }
        return res;
    }
}
