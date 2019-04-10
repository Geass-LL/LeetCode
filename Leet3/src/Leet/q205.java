package Leet;

import java.util.*;

public class q205 {
	public boolean isIsomorphic(String s,String t) {
		return help(s,t)&&help(t,s);
	}
	boolean help(String s, String t) {
		if(s==null&&t==null) return true;
		if(s.length()!=t.length()) return false;
		int length=s.length();
		Map<Character,Character> map=new HashMap<Character,Character>();
		for(int i=0;i<length;i++) {
			if(!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i),t.charAt(i));
			}else if(map.get(s.charAt(i))!=t.charAt(i)) {
				return false;
			}
		}
		return true;
    }
}
