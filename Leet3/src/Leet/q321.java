package Leet;

import java.util.*;

public class q321 {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] maxres=new int[k],res=new int[k];
		int length1=nums1.length,length2=nums2.length;
		for(int i=0;i<=k;i++) {
			if(length1>=i&&length2>=(k-i)) {
				if(i==0) {
					res=choose(nums2,k);
				}else if(i==k) {
					res=choose(nums1,k);
				}else {
					res=compat(choose(nums1,i),choose(nums2,k-i));
				}
				if(gthan(res,0,maxres,0)) {
					maxres=res;
				}
			}
		}
		return maxres;
    }
	static int[] compat(int[] nums1,int[] nums2) {
		int length1=nums1.length,length2=nums2.length;
		int length=length1+length2;
		int[] nums=new int[length];
		int cur1=0,cur2=0,i=0;
		while(cur1<length1&&cur2<length2) {
			if(gthan(nums1,cur1,nums2,cur2)) {
				nums[i++]=nums1[cur1++];
			}else {
				nums[i++]=nums2[cur2++];
			}
		}
		while(cur1<length1) {
			nums[i++]=nums1[cur1++];
		}
		while(cur2<length2) {
			nums[i++]=nums2[cur2++];
		}
		return nums;
	}
	static int[] choose(int[] nums,int k) {
		/*
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++) {
			list.add(nums[i]);
		}
		while(list.size()>k) {
			int i=0;
			boolean del=false;
			while(i<list.size()-1) {
				if(list.get(i)<list.get(i+1)) {
					list.remove(i);
					del=true;
					break;
				}else {
					i++;
				}
			}
			if(!del) {
				list.remove(list.size()-1);
			}
		}
		int[] res=new int[list.size()];
		for(int i=0;i<list.size();i++) {
			res[i]=list.get(i);
		}
		return res;*/
		int[] res = new int[k];
		int length=nums.length;
		int j=0;
		for(int i=0;i<nums.length;i++) {
			while(j>0&&length-i+j>k&&res[j-1]<nums[i]) {
				j--;
			}
			if(j<k) {
				res[j++]=nums[i];
			}
		}
		return res;
	}
	static boolean gthan(int[] nums1,int index1,int[] nums2,int index2) {
		while(index1<nums1.length&&index2<nums2.length) {
			if(nums1[index1]>nums2[index2]) {
				return true;
			}else if(nums1[index1]<nums2[index2]) {
				return false;
			}else {
				index1++;
				index2++;
			}
		}
		if(index1<nums1.length) {
			return true;
		}else {
			return false;
		}
	}
}
