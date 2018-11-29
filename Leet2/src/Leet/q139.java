package Leet;

import java.util.*;



public class q139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		int length=s.length();
		Set<String> words=new HashSet<String>(wordDict);
		boolean[] res=new boolean[length+1];
		res[0]=true;
		for(int i=1;i<=length;i++) {
			for(int j=i-1;j>=0;j--) {
				boolean cur=res[j]&words.contains(s.substring(j, i));
				res[i]|=cur;
				if(cur) break;
			}
		}
		return res[length];
    }
}
