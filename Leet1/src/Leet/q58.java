package Leet;

public class q58 {
	public int lengthOfLastWord(String s) {
		int res=0;
		int i=s.length()-1;
		while(i>=0) {
			if(res!=0&&s.charAt(i)==' ') return res;
			if(s.charAt(i)!=' ')
				res++;
			i--;
		}
		return res;
    }
}
