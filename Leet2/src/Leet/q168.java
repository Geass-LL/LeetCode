package Leet;

//注意和十进制的规则不一样，这里的最低位可以为26，但十进制的低位最大也只能是9。这一点需要特别处理。

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
