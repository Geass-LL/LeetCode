package Leet;

public class q242 {
	public boolean isAnagram(String s, String t) {
		if(s==null&&t==null)	return true;
		if(s==null||t==null)	return false;
		if(s.length()!=t.length())	return false;
		int[] map=new int[26];
		char[] schs=s.toCharArray(),tchs=t.toCharArray();
		for(int i=0;i<schs.length;i++) {
			map[schs[i]-'a']++;
		}
		for(int i=0;i<tchs.length;i++) {
			map[tchs[i]-'a']--;
		}
		for(int i=0;i<26;i++) {
			if(map[i]!=0)	return false;
		}
		return true;
    }
}
