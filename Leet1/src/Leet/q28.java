package Leet;

/*
 * mad,ԭ��java���������������indexof
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
