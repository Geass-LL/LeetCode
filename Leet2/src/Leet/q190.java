package Leet;

/*
 * ������ԭ�е�Integer���������޸ģ��������½�����һ��Integer��
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
