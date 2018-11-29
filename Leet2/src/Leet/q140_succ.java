package Leet;

import java.util.*;

/*
 * �ŵ㣺��֮ǰ�Ľ�����˴��档
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
			String first=s.substring(0, i);//ǰ�벿��
			if(words.contains(first)) {
				List<String> ans=btk(map,s.substring(i),words);//��벿��
				for(String eachans:ans) {
					res.add(first+" "+eachans);//�ϲ�ǰ�벿�����벿��
				}
			}
		}
		map.put(s, res);//����Map����Ȼ�ظ��ļ��������ʱ��
		return res;
	}
}
