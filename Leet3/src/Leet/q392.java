package Leet;

public class q392 {
	public boolean isSubsequence(String s, String t) {
		if(s.length()>t.length())	return false;
		int i=0,j=0;
		while(i<s.length()&&j<t.length()) {
			if(s.charAt(i)==t.charAt(j)) {
				i++;
				j++;
			}else {
				j++;
			}
		}
		if(i==s.length())	return true;
		else	return false;
    }
}