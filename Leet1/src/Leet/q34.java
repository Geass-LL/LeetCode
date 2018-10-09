package Leet;

import java.util.Arrays;
/*
 * 先用二分搜索找到这个数，如果找不到直接返回-1；
 * 找到这个数，再分左右根据二分搜索找：
 * 左侧：该位置的值不为target，但它右侧为target【注意0时越界】；
 * 右侧：该位置的值不为target，但它左侧为target【注意最右侧越界】。
 * 在寻找时，左侧的右值如果mid相等也应左移，右侧的左值如果mid相等也应右移。
 */
public class q34 {
    public int[] searchRange(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int res=-1;
        while(left<=right) {
        	int mid=(left+right)/2;
        	if(nums[mid]==target) {
        		res=mid;
        		break;
        	}else if(nums[mid]<target) {
        		left=mid+1;
        	}else {
        		right=mid-1;
        	}
        }
        int[] result=new int[2];
        if(res==-1) {
        	result[0]=-1;
        	result[1]=-1;
        }else {
        	result[0]=cacul(nums,res,target);
        	result[1]=cacur(nums,res,target);
        }
    	return result;
    }
    int cacul(int[] nums,int innum,int target) {
    	int left=0,right=innum,res=innum;
    	while(left<=right) {
    		int mid=(left+right)/2;
    		if(nums[0]==target) {
    			res=0;
    			break;
    		}
    		if(nums[mid]!=target&&nums[mid+1]==target) {
    			res=mid+1;
    			break;
    		}else if(nums[mid]<target) {
    			left=mid+1;
    		}else {
    			right=mid-1;
    		}
    	}
    	return res;
    }
    int cacur(int[] nums,int innum,int target) {
    	int left=innum,right=nums.length-1,res=innum;
    	while(left<=right) {
    		int mid=(left+right)/2;
    		if(nums[nums.length-1]==target) {
    			res=nums.length-1;
    			break;
    		}
    		if(nums[mid]==target&&nums[mid+1]!=target) {
    			res=mid;
    			break;
    		}else if(nums[mid]>target) {
    			right=mid-1;
    		}else {
    			left=mid+1;
    		}
    	}
    	return res;
    }
}
