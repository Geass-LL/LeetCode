package Leet;

/*
 * �����������Ĵ𰸡�
 * ����˼�뻹�ǵݹ顣
 * �ο����ͣ�https://blog.csdn.net/u012501459/article/details/46622501
 * �����F(i,n)=G(i-1)*G(n-i) ��û���뵽�ġ�
 */

public class q96 {
	public int numTrees(int n) {
		int res[]=new int[n+1];
		res[0]=1;
		res[1]=1;
		for(int i=2;i<=n;i++) {
			for(int j=0;j<i;j++) {
				res[i]+=res[j]*res[i-1-j];
			}
		}
		return res[n];
	}
}
