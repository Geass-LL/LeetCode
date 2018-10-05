package Leet;

import java.util.*;
/*
 *�㲻���������ʲô��˼���ѵ㽵���ˣ�
 *1�����������е��ʵĳ��ȶ���ͬ���ݴ˿����ų���һЩ���⣻
 *2�����������еĵ��ʶ�Ҫ���ϣ��ݴ˿��Եõ���ĳ����ǹ̶��ģ�
 *ά��һ��Map����map��ֵ��ʾ�õ����������г��ֵĴ�������Ϊ�����еĵ��ʿ����ظ����֡�
 *iָ��ÿ�μ�һ����i->i+sentence_length���ַ�����ÿword_length�ж��Ƿ���map�г�����map��ֵ���㣬
 *����ֵ��С1������ֱ���˳�ѭ����i++��
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
