package Leet;

import java.util.*;
/*
 * ֻ��һ��������û�н�����㷨Ӧ��û�����⣬���ǳ�ʱ�ˣ�Ч���ϲ��С�
 */
public class q76 {
    public String minWindow(String s, String t) {
    	String res="";
    	if(t.length()==0||s.length()==0)
    		return "";
    	//�Ƚ�һ��Map��key��char��value��char���ֵĴ���
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
			//ÿ�δӵ�ǰ��left�������õ���������������С����
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
			//�����С�����Ѿ��õ�������λ��left��right֮�䣬temp�ĸ���ֵ��ʾ������������ظ���
			if(count==map.size()) {
				while(left<right) {
					char tempkey=s.charAt(left);
					if(tempmap.containsKey(tempkey)) {
						int curvalue=(int)tempmap.get(tempkey);
						if(curvalue<0) {
							tempmap.replace(tempkey, curvalue+1);//ȥ��һ���ظ�
						}else {
							if(right-left<res.length()||res=="")
								res=s.substring(left, right);
							left++;
							while(left<s.length()&&!map.containsKey(s.charAt(left)))//����left
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














