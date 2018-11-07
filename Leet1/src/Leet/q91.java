package Leet;


public class q91 {
	public int numDecodings(String s) {
		int i=0;
		int[] res=new int[s.length()+1];
		while(i<s.length()) {
			if(s.charAt(i)=='0') {	//如果当前为0
				if(i>=1&&(s.charAt(i-1)=='1'||s.charAt(i-1)=='2')) { 	//这个0有可能组成10或者20，则为前两步的结果
						res[i+1]=res[i-1];
				}else {	//如果没有组成10和20的可能，那么当前位置为0
					res[i+1]=0;	//直接结束
					break;
				}
				i++;
			}else if(i==0){	//非0开始，0位置初始化为1，1位置也初始化为1
				res[0]=1;
				res[1]=1;
				i++;
			}else {
				int temp=(s.charAt(i-1)-'0')*10+(s.charAt(i)-'0');
				if(temp>10&&temp<=26) {	//前一个数字非0，并且在11到26的范围内
					res[i+1]=res[i]+res[i-1];	//迭代，合并则为res[i-1]，不合并则为res[i]；合并与不合并的情况相加
				}else {
					res[i+1]=res[i];	//迭代
				}
				i++;
			}
		}
		return res[s.length()];
    }
	
}
