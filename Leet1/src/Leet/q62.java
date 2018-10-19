package Leet;
/*
 * 看大神的呀。
 * 不能盲目动态规划，因为结果并没有被保存下来。
 * 用动态规划的思路建立递归关系式后，从前往后做。
 * a[i][j]=a[i-1][j]+a[i][j-1]
 * 下面的方法是对空间的优化。
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
