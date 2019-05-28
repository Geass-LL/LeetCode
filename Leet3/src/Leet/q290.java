package Leet;

import java.util.*;

public class q290 {
	public boolean wordPattern(String pattern, String str) {
		String[] map=new String[26];
		Set<String> set=new HashSet<>();
		int j=0;
		for(int i=0;i<pattern.length();i++) {
			String cur="";
			while(j<str.length()&&str.charAt(j)!=' ') {
				cur+=str.charAt(j);
				j++;
			}
			int index=pattern.charAt(i)-'a';
			if(map[index]==null) {
				for(int k=0;k<26;k++) {
					if(map[k]!=null&&map[k].equals(cur)) return false;
				}
				if(cur.length()>0)	map[index]=cur;
				else return false;
			}else {
				if(!map[index].equals(cur)) return false;
			}
			while(j<str.length()&&str.charAt(j)==' ') {
				j++;
			}
		}
		if(j==str.length())	return true;
		else	return false;
    }
}
