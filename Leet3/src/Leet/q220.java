package Leet;

import java.util.*;

/*
 * 暴力查找的办法，效率极低；
 */

public class q220 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			for(int j=1;j<=k&&i-j>=0;j++) {
				long temp=Math.abs((long)nums[i]-(long)nums[i-j]);
				if(temp<=t) {
					return true;
				}
			}
		}
		return false;
    }
}
