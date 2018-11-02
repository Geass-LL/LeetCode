package Leet;

public class q73 {
	public void setZeroes(int[][] matrix) {
		if(matrix.length==0||matrix==null)
			return;
		else {
			int m=matrix.length,n=matrix[0].length;
			int[] pos=new int[m+n];
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(matrix[i][j]==0) {
						pos[i]=1;
						pos[j+m]=1;
					}
				}
			}
			for(int i=0;i<m;i++) {
				if(pos[i]==1) {
					for(int j=0;j<n;j++)
						matrix[i][j]=0;
				}
			}
			for(int j=0;j<n;j++) {
				if(pos[j+m]==1) {
					for(int i=0;i<m;i++) {
						matrix[i][j]=0;
					}
				}
			}
		}
    }
}
