package Leet;

//ע���ʮ���ƵĹ���һ������������λ����Ϊ26����ʮ���Ƶĵ�λ���Ҳֻ����9����һ����Ҫ�ر���

public class q168 {
	public String convertToTitle(int n) {
		String res="";
		while(n>26) {
			if(n%26!=0) {
				res=String.valueOf((char)(n%26+64))+res;
				n/=26;
			}else {
				res="Z"+res;
				n/=26;
				n-=1;
			}
		}
		return String.valueOf((char)(n+64))+res;
    }
}
