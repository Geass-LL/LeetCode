package Leet;

/*
 * ��Ӳ���㷨�����Ч��Ҳ̫���˵���ɡ�
 * ��res[i][j]��ʾ��i��j����С�и������
 * ÿ�ε������������ĸ��ͬ�ģ�������ڲ�������Ϊ0��������ÿһ�����ܵ��и�㡣
 */

public class q132 {
	public int minCut(String s) {
		int length=s.length();
		if(length<=1) return 0;
		int[][] res=new int[length][length];
		res[0][0]=0;
		char[] chas=s.toCharArray();
		for(int j=1;j<length;j++) {
			char cur=chas[j];
			for(int i=j-1;i>=0;i--) {
				if(i==j-1) {
					if(cur==chas[i]) res[i][j]=0;//������ڲ�������Ϊ0��
					else res[i][j]=1;
				}else {
					if(cur==chas[i]&&res[i+1][j-1]==0){//������ڲ�������Ϊ0��
						res[i][j]=0;
					}else {
						int minlength=Integer.MAX_VALUE;
						for(int k=i;k<j;k++) {//������ÿһ�����ܵ��и�㡣
							if(res[i][k]+res[k+1][j]+1<minlength)
								minlength=res[i][k]+res[k+1][j]+1;
						}
						res[i][j]=minlength;
					}
				}
			}
		}
		return res[0][length-1];
    }
}
