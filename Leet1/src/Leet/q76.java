package Leet;

import java.util.*;
/*
 * 只有一个测试例没有解决，算法应该没有问题，但是超时了，效率上不行。
 */
public class q76 {
    public String minWindow(String s, String t) {
    	String res="";
    	if(t.length()==0||s.length()==0)
    		return "";
    	//先建一个Map，key是char，value是char出现的次数
    	Map map=new HashMap<Character,Integer>();
    	for (int i=0;i<t.length();i++) {
    		char tempkey=t.charAt(i);
    		if(map.containsKey(tempkey))
    			map.replace(tempkey, (int)map.get(tempkey)+1);
    		else
    			map.put(tempkey, 1);
    	}
		int left=0,right=0;
		while(left<s.length()) {
			int count=0;
			right=left;
			//每次从当前的left出发，得到能满足条件的最小序列
			Map tempmap=new HashMap(map);
			while(count<map.size()&&right<s.length()) {
				char tempkey=s.charAt(right);
				if(tempmap.containsKey(tempkey)) {
					int curvalue=(int)tempmap.get(tempkey);
					if(curvalue==1)
						count++;
					tempmap.replace(tempkey, curvalue-1);
				}
				right++;
			}
			//这个最小序列已经得到，并且位于left和right之间，temp的负数值表示可以允许多少重复；
			if(count==map.size()) {
				while(left<right) {
					char tempkey=s.charAt(left);
					if(tempmap.containsKey(tempkey)) {
						int curvalue=(int)tempmap.get(tempkey);
						if(curvalue<0) {
							tempmap.replace(tempkey, curvalue+1);//去掉一层重复
						}else {
							if(right-left<res.length()||res=="")
								res=s.substring(left, right);
							left++;
							while(left<s.length()&&!map.containsKey(s.charAt(left)))//更新left
								left++;
							break;
						}
					}
					left++;
				}
			}else {
				break;
			}
		}
        return res;
    }
}














