package Leet;

import java.util.*;

public class q228 {
	public List<String> summaryRanges(int[] nums) {
		List<String> res=new ArrayList<String>();
		if(nums==null||nums.length==0)	return res;
		String cur=String.valueOf(nums[0]);
		for(int i=1;i<nums.length;i++) {
			if(nums[i]-nums[i-1]==1) {
				if(cur.charAt(cur.length()-1)!='>')	cur+="->";
			}else {
				if(cur.charAt(cur.length()-1)=='>')	cur+=String.valueOf(nums[i-1]);
				res.add(cur);
				cur=String.valueOf(nums[i]);
			}
		}
		if(cur.charAt(cur.length()-1)=='>')		res.add(cur+=String.valueOf(nums[nums.length-1]));
		else	res.add(cur);
		return res;
    }
}
