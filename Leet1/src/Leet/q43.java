package Leet;
/*
 * ��ͳ������ʽ�ķ�����
 * ���ǱȽϼ򵥵ġ�
 */
public class q43 {
	public String multiply(String num1, String num2) {
		int length1=num1.length(),length2=num2.length();
		//���ĳ������Ϊ�����ͱ���������֮��
		int[] res=new int[length1+length2];
		for(int i=length1-1;i>=0;i--) {
			int a=(int)num1.charAt(i)-(int)'0';
			int index=length1-1-i;
			int addnum=0;
			for(int j=length2-1;j>=0;j--) {
				int b=(int)num2.charAt(j)-(int)'0';
				int temp=a*b+res[index]+addnum;//��Ҫ����ǰλ�Ĵ�С������һ�ε�ֵ���������������ֵ���ӽ�λ
				res[index]=temp%10;//ȡ��λ������
				addnum=temp/10;//ȡʮλ������
				index++;
			}
			res[index]=addnum;//��������λ���ٴ�����������λ����0����Ȼ
		}
		String strres="";
		int starti=0;
		for(int i=res.length-1;i>=0;i--) {
			if(res[i]!=0) {
				starti=i;//��ʲôʱ��ʼ��Ϊ0
				break;
			}
		}
		for (int i=starti;i>=0;i--) {
			strres+=(char)((int)'0'+res[i]);//ת�����ַ���
		}
		if(strres.length()==0) {
			strres="0";//ȫ0���0
		}
		return strres;
    }
}
