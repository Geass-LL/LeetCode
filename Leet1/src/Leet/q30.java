package Leet;

import java.util.*;
/*
 *搞不清这个题有什么意思，难点降低了：
 *1、数组中所有单词的长度都相同，据此可以排除掉一些问题；
 *2、数组中所有的单词都要用上，据此可以得到解的长度是固定的；
 *维护一个Map，让map的值表示该单词在数组中出现的次数，因为数组中的单词可以重复出现。
 *i指针每次加一，对i->i+sentence_length的字符串，每word_length判断是否在map中出现且map的值非零，
 *是则值减小1，否则直接退出循环，i++；
 */
public class q30 {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res=new ArrayList();
		Map map=new HashMap();
		for (String word:words) {
			if(!map.containsKey(word)) {
				map.put(word, 1);
			}else {
				int value=(int) map.get(word);
				map.put(word, value+1);
			}
		}
		if(s.length()==0||s==null||words==null||words.length==0) {
			return res;
		}
		int wordlength=words[0].length();
		for(int i=1;i<words.length;i++) {
			if (words[i].length()!=wordlength) {
				return res;
			}
		}
		int slength=wordlength*words.length;
		for (int i=0;i<=s.length()-slength;i++) {
			String teststring=s.substring(i, i+slength);
			int j=0;
			Map maptemp=new HashMap(map);
			boolean addor=true;
			while(j<=slength-wordlength) {
				String nowword=teststring.substring(j,j+wordlength);
				if(maptemp.containsKey(nowword)&&((int)maptemp.get(nowword)!=0)) {
					maptemp.put(nowword, (int)maptemp.get(nowword)-1);
					j+=wordlength;
				}else {
					addor=false;
					break;
				}
			}
			if(addor) {
				res.add(i);
			}
		}
		return res;
    }
}
