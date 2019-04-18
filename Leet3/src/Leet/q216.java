package Leet;

import java.util.*;

public class q216 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(k==0) return res;
		boolean[] nums=new boolean[9];
		btk(res,new ArrayList<Integer>(),k,n,nums,1);
		return res;
    }
	void btk(List<List<Integer>> res,List<Integer> tempres,int k,int n,boolean[] nums,int start) {
		if(tempres.size()==k) {
			int sum=0;
			for(int eachnum:tempres) {
				sum+=eachnum;
			}
			if(sum==n)	res.add(new ArrayList<Integer>(tempres));
			return;
		}else {
			for(int i=start;i<=9;i++) {
				if(!nums[i-1]) {
					nums[i-1]=true;
					tempres.add(i);
					btk(res,tempres,k,n,nums,i);
					tempres.remove(tempres.size()-1);
					nums[i-1]=false;
				}
			}
		}
	}
}
