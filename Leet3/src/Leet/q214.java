package Leet;

/*
 * ˼·��
 * ������Σ��ԳƲ������Ҳ�Ӧ��ͬ��һ��char��ͬ��
 * ȡ��0��charΪtarget����i=1��ʼ�����ַ�Ϊtarget�ģ�
 * ����ҵ���target����ǰλ���Ƿ���ȫ�Գƣ���һ�����Գ���ȡ������ȫ�Գ����¼��ǰλ��right��
 * �Ӽ�¼��right��ʼ��ȫ��
 */

public class q214 {
	public String shortestPalindrome(String s) {
		if(s==null||s.length()==0) return "";
		if(s.length()==1) return s;
		char[] chs=s.toCharArray();
		char target=chs[0];//ȡ��0��charΪtarget��
		int right=0;//right��ʼ��Ϊ0
		for(int i=1;i<chs.length;i++) {//��i=1��ʼ�����ַ�Ϊtarget�ģ�
			if(chs[i]==target) {//���ַ�Ϊtarget�ģ�����ҵ���
				int j=1;
				while(j<=i-j) {//target����ǰλ���Ƿ���ȫ�Գƣ�
					if(chs[j]!=chs[i-j])	break;//��һ�����Գ���ȡ��
					j++;
				}
				if(j>i-j)	right=i;//��ȫ�Գ����¼��ǰλ��right��
			}
		}
		String res="";
		for(int i=chs.length-1;i>right;i--) {
			res+=chs[i];//�Ӽ�¼��right��ʼ��ȫ��
		}
		return res+=s;
    }
}
