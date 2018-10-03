package Leet;

/*
 * mad,原来java内置了这个方法：indexof
 */
public class q28 {
    public int strStr(String haystack, String needle) {
        int length=needle.length();
        for (int i=0;i<=haystack.length()-length;i++) {
        	if(haystack.substring(i, i+length).equals(needle)) {
        		return i;
        	}
        }
        return -1;
    }
}
