package Leet;

/*
 * 并非在原有的Integer基础上做修改，而是重新建立了一个Integer。
 */

public class q190 {
	public int reverseBits(int n) {
		int res=0;
		for(int i=0;i<32;i++) {
			if((n&1)==1) {
				res<<=1;
				res|=1;
			}else {
				res<<=1;
			}
			n>>=1;
		}
		return res;
    }
}
