package Leet;
/*
 * �������ѽ��
 * ����äĿ��̬�滮����Ϊ�����û�б�����������
 * �ö�̬�滮��˼·�����ݹ��ϵʽ�󣬴�ǰ��������
 * a[i][j]=a[i-1][j]+a[i][j-1]
 * ����ķ����ǶԿռ���Ż���
 * https://blog.csdn.net/happyaaaaaaaaaaa/article/details/50856112
 */
public class q62 {
	public int uniquePaths(int m, int n) {
       int[] res=new int[n];
       res[0]=1;
       for(int i=0;i<m;i++) {
    	   for(int j=1;j<n;j++)
    		   res[j]+=res[j-1];
       }
       return res[n-1];
    }
}
