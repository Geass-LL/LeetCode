package Leet;

import java.util.*;

/*
 * ����������Ϊ����ϤJava�ڽ��ĺ���
 * Arrays.sort()���ԶԺܶ�����������򣬱��������char[]��
 * �����ŵ���ʹ������������ת���ɵ��ַ�����Ϊ����ֵ�������롣
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
