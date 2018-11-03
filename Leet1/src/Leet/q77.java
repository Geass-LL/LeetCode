package Leet;

import java.util.*;
/*
 * 经典的回溯法，复习复习了。
 */
public class q77 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		int[] cacn=new int[n];
		for(int i=0;i<n;i++) {
			cacn[i]=i+1;
		}
		btk(res,new ArrayList<Integer>(),cacn,k,0);
		return res;
    }
	void btk(List<List<Integer>> res,List<Integer> temp,int[] cacn,int k,int deep) {
		if(temp.size()==k) {
			res.add(new ArrayList(temp));
		}else {
			for(int i=deep;i<cacn.length;i++) {
				temp.add(cacn[i]);
				btk(res,temp,cacn,k,i+1);
				temp.remove(temp.size()-1);
			}
		}
	}
}
