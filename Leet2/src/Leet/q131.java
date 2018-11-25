package Leet;

import java.util.*;

/*
 * 采用动态规划的思路，具体见OneNote
 */

public class q131 {
	public List<List<String>> partition(String s) {
		List<List<String>> res=new ArrayList<List<String>>();
		if(s.length()==0) return res;
		List<String> curres=new ArrayList<String>();
		curres.add(s.substring(0, 1));
		res.add(curres);
        for(int i=1;i<s.length();i++) {
        	List<List<String>> tempres=new ArrayList<List<String>>();
        	for(List<String> eachres:res) {
        		eachres.add(s.substring(i,i+1));
        		List<String> temp=new ArrayList<String>(eachres);
        		if(mergeEachres(temp)) {
        			tempres.add(temp);
        		}
        	}
        	if(tempres!=null) res.addAll(tempres);
        }
        return res;
    }
	boolean mergeEachres(List<String> list) {
		if(allsame(list.get(list.size()-2),list.get(list.size()-1))) {
			list.set(list.size()-2, list.get(list.size()-2)+list.get(list.size()-1));
			list.remove(list.size()-1);
			return true;			
		}else if(list.size()>=3&&list.get(list.size()-3).equals(list.get(list.size()-1))) {
			list.set(list.size()-3, list.get(list.size()-3)+list.get(list.size()-2)+list.get(list.size()-1));
			list.remove(list.size()-1);
			list.remove(list.size()-1);
			return true;
		}else {
			return false;
		}
	}
	boolean allsame(String input,String input2) {
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)!=input2.charAt(0)) return false;
		}
		return true;
	}
}
