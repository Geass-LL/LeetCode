package Leet;

public class q191 {
	public int hammingWeight(int n) {
		int res=0;
		for(int i=0;i<32;i++) {
			if((n&1)==1) {
				res++;
			}
			n>>=1;
		}
		return res;
    }
}
