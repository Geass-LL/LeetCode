package Leet;

import java.util.*;

public class q349 {
	public int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> res=new ArrayList<Integer>();
		Map<Integer,Boolean> map=new HashMap<Integer,Boolean>();
		for(int i=0;i<nums1.length;i++) {
			if(!map.containsKey(nums1[i])) {
				map.put(nums1[i], true);
			}
		}
		for(int i=0;i<nums2.length;i++) {
			if(map.containsKey(nums2[i])&&map.get(nums2[i])) {
				res.add(nums2[i]);
				map.put(nums2[i], false);
			}
		}
		int[] listres=new int[res.size()];
		for(int i=0;i<listres.length;i++) {
			listres[i]=res.get(i);
		}
		return listres;
    }
}
