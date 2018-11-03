package Leet;

import java.util.HashMap;
import java.util.Map;

/*
 * 见OneNote，与我的76的不同在于，他只维护了一个map，而且里面只有大循环。
 */
public class q76_new {
	public String minWindow(String s, String t) {
    	String res="";
    	if(t.length()>s.length())
    		return "";
    	//先建一个Map，key是char，value是char出现的次数
    	Map<Character, Integer> map=new HashMap<Character,Integer>();
    	for (int i=0;i<t.length();i++) {
    		char tempkey=t.charAt(i);
    		if(map.containsKey(tempkey))
    			map.put(tempkey, map.get(tempkey)+1);
    		else
    			map.put(tempkey, 1);
    	}
    	//--------------------------------------------
		int left=0,right=0,count=0;
		for(right=0;right<s.length();right++) {
			char curright=s.charAt(right);
			if(map.containsKey(curright)) {
				map.put(curright, map.get(curright)-1);
				if(map.get(curright)>=0) count++;
				while(count==t.length()) {
					if(right-left+1<res.length()||res=="") res=s.substring(left, right+1);
					char curleft=s.charAt(left);
					if(map.containsKey(curleft)) {
						map.put(curleft, map.get(curleft)+1);
						if(map.get(curleft)>0) count--;
					}
					left++;
				}
			}
		}
        return res;
    }
}
