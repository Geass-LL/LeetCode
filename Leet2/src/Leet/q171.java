package Leet;

public class q171 {
	public int titleToNumber(String s) {
		int res=0;
		char[] temps=s.toCharArray();
		for(int i=0;i<temps.length;i++) {
			int temp=temps[i]-'A'+1;
			res=res*26+temp;
		}
		return res;
    }
}
