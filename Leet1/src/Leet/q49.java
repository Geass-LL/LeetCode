package Leet;

import java.util.*;

/*
 * 觉得难是因为不熟悉Java内建的函数
 * Arrays.sort()可以对很多对象数组排序，比如这里的char[]。
 * 所以优点在使用排序后的数组转换成的字符串作为键，值慢慢引入。
 */
public class q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> res=new ArrayList();
    	if(strs.length==0)
    		return res;
    	Map<String,List<String>> map=new HashMap<String,List<String>>();
    	for(String eachstr:strs) {
    		char[] temp=eachstr.toCharArray();
    		Arrays.sort(temp);
    		String keystr=temp.toString();
    		if(map.containsKey(keystr)) {
    			map.get(keystr).add(eachstr);
    		}else {
    			List<String> tempvalue=new ArrayList<String>();
    			tempvalue.add(eachstr);
    			map.put(keystr, tempvalue);
    		}
    	}
    	for(List<String> eachvalue:map.values()) {
    		res.add(eachvalue);
    	}
    	return res;
    }
}
