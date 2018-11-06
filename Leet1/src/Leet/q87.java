package Leet;

import java.util.Arrays;
/*
 * ²Î¿¼²©¿Í£º
 * https://blog.csdn.net/yanqinghe123/article/details/78244984
 * https://blog.csdn.net/jin_kwok/article/details/51136509
 */
public class q87 {
	public boolean isScramble(String s1, String s2) {
		return dyp(s1,s2);
    }
	boolean dyp(String s1,String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		if(s1.equals(s2)) {
			return true;
		}
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if(!Arrays.equals(c1, c2)) {
			return false;
		}
		for(int i=1;i<s1.length();i++) {
			if(
				dyp(s1.substring(0, i),s2.substring(0, i))
				&&
				dyp(s1.substring(i),s2.substring(i))
				||
				dyp(s1.substring(0,i),s2.substring(s2.length()-i))
				&&
				dyp(s1.substring(i),s2.substring(0,s2.length()-i))
			)
				return true;
		}
		return false;
	}
}
