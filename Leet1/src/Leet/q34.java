package Leet;

import java.util.Arrays;
/*
 * ���ö��������ҵ������������Ҳ���ֱ�ӷ���-1��
 * �ҵ���������ٷ����Ҹ��ݶ��������ң�
 * ��ࣺ��λ�õ�ֵ��Ϊtarget�������Ҳ�Ϊtarget��ע��0ʱԽ�硿��
 * �Ҳࣺ��λ�õ�ֵ��Ϊtarget���������Ϊtarget��ע�����Ҳ�Խ�硿��
 * ��Ѱ��ʱ��������ֵ���mid���ҲӦ���ƣ��Ҳ����ֵ���mid���ҲӦ���ơ�
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
