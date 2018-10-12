package Leet;
/*
 * 传统的列数式的方法；
 * 还是比较简单的。
 */
public class q43 {
	public String multiply(String num1, String num2) {
		int length1=num1.length(),length2=num2.length();
		//积的长度最大为乘数和被乘数长度之和
		int[] res=new int[length1+length2];
		for(int i=length1-1;i>=0;i--) {
			int a=(int)num1.charAt(i)-(int)'0';
			int index=length1-1-i;
			int addnum=0;
			for(int j=length2-1;j>=0;j--) {
				int b=(int)num2.charAt(j)-(int)'0';
				int temp=a*b+res[index]+addnum;//重要，当前位的大小等于上一次的值，加现在算出来的值，加进位
				res[index]=temp%10;//取个位存起来
				addnum=temp/10;//取十位存起来
				index++;
			}
			res[index]=addnum;//最后如果进位，再存起来，不进位，存0，当然
		}
		String strres="";
		int starti=0;
		for(int i=res.length-1;i>=0;i--) {
			if(res[i]!=0) {
				starti=i;//找什么时候开始不为0
				break;
			}
		}
		for (int i=starti;i>=0;i--) {
			strres+=(char)((int)'0'+res[i]);//转换成字符串
		}
		if(strres.length()==0) {
			strres="0";//全0则出0
		}
		return strres;
    }
}
