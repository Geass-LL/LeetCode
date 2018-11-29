package Leet;

import java.util.*;

/*
 * 用Hash表记录每个起点可能到达的所有终点，通过DFS的方法遍历。
 * 缺点：TLE。
 */

public class q140 {
	public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        Set<String> words=new HashSet<String>(wordDict);
        int length=s.length();
        for(int i=0;i<length;i++) {
        	List<Integer> curval=new ArrayList<Integer>();
        	for(int j=i;j<length;j++) {
        		if(words.contains(s.substring(i, j+1)))
        			curval.add(j);
        	}
        	map.put(i, curval);
        }
        List<String> res=new ArrayList<String>();
        btk(res,0,length,"",map,s);
        return res;
    }
	void btk(List<String> res,int start,int length,String tempres,Map<Integer,List<Integer>> map,String s) {
		if(start==length) {
			res.add(new String(tempres.substring(0, tempres.length()-1)));
		}else {
			for(int newstart:map.get(start)) {
				tempres+=s.substring(start,newstart+1);
				tempres+=" ";
				btk(res,newstart+1,length,tempres,map,s);
				tempres=tempres.substring(0,tempres.length()-(newstart+1-start)-1);
			}
		}
	}
}
