package Leet;

/*
 * ��6527��
 * ��λ��1��ʮλ��+��λǰ(>=2:1								652+1(7>=2)
 * 						(<1 :0
 * 						(����:1
 * ʮλ��1����λ��*10+ʮλǰ(>=20:10							65*10+10(27>=20)
 * 						   (<10:0
 * 						   (����:ʮλǰ-9
 * ��λ��1��ǧλ��*100+��λǰ(>=200:100						6*100+100(527>=200)
 * 							(<100:0
 * 							(����:��λǰ-99
 * ��������
 */

public class q233 {
	public int countDigitOne(int n) {
		if(n<=0)	return 0;
		long res=0,temp=1;//����ע����long����Ȼ�ᳬ����
		while(n>=temp) {
			long left=n/(temp*10),right=n%(temp*10);//leftΪ�Ӻŵ�ǰ�벿�֣�rightΪ�Ӻŵĺ�벿��
			if(temp==1) {
				res+=left;
				res+=right>=1?1:0;//��λ�ıȽ�����
			}else {
				res+=left*temp;
				if(right>=2*temp) {
					res+=temp;
				}else {
					res+=right>=temp?(right-temp+1):0;
				}
			}
			temp*=10;
		}
		return (int)res;
    }
}
