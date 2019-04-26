package Leet;

/*
 * d[i][j]表示以第i,j点为右下角的正方形最大边长。
 */
public class q221 {
	public int maximalSquare(char[][] matrix) {
		if(matrix==null|matrix.length==0||matrix[0].length==0)	return 0;
		int m=matrix.length,n=matrix[0].length,res=0;
		int[][] d=new int[m][n];
		for(int i=0;i<n;i++) {
			if(matrix[0][i]=='1') {
				d[0][i]=1;
				res=1;
			}
			else	d[0][i]=0;
		}
		for(int i=0;i<m;i++) {
			if(matrix[i][0]=='1') {
				d[i][0]=1;
				res=1;
			}
			else d[i][0]=0;
		}
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
                if(matrix[i][j]=='1') {
                	d[i][j]=Math.min(d[i-1][j-1],Math.min(d[i-1][j],d[i][j-1]))+1;
                	if(d[i][j]>res)	res=d[i][j];
                }
                else	d[i][j]=0;
			}
		}
		return res*res;
    }
}
