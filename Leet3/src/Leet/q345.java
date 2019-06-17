package Leet;

public class q345 {
	public String reverseVowels(String s) {
		if(s.length()<=1) 	return s;
		int left=0,right=s.length()-1;
		char[] chs=s.toCharArray();
		while(left<right) {
			if(!isv(chs[left])) {
				left++;
			}
			if(!isv(chs[right])) {
				right--;
			}
			if(isv(chs[left])&&isv(chs[right])) {
				char temp=chs[left];
				chs[left]=chs[right];
				chs[right]=temp;
				left++;
				right--;
			}
		}
		return String.valueOf(chs);
    }
	boolean isv(char ch) {
		if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||
			ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')	return true;
		return false;
	}
}
