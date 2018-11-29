package Leet;

import java.util.*;

/*
 * 优点：将之前的结果做了储存。
 */

public class q140_succ {
	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		Set<String> words=new HashSet(wordDict);
		return btk(map,s,words);
	}
	List<String> btk(Map<String,List<String>> map,String s,Set<String> words){
		if(map.containsKey(s)) return map.get(s);
		List<String> res=new ArrayList<String>();
		if(words.contains(s)) res.add(s);
		for(int i=1;i<s.length();i++) {
			String first=s.substring(0, i);//前半部分
			if(words.contains(first)) {
				List<String> ans=btk(map,s.substring(i),words);//后半部分
				for(String eachans:ans) {
					res.add(first+" "+eachans);//合并前半部分与后半部分
				}
			}
		}
		map.put(s, res);//存入Map，不然重复的计算会引起超时。
		return res;
	}
}
