package Leet;

import java.util.*;

public class q519 {
	public int[][] matrix;
	public int n;
	public int m;
	public int size;
	public q519(int n_rows, int n_cols) {
		n=n_rows;
		m=n_cols;
		size=m*n;
        matrix=new int[n_rows][n_cols];
    }
    
    public int[] flip() {
        Random random=new Random();
        int index=random.nextInt(size);
        int count=0;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		if(matrix[i][j]==0&&count==index) {
        			matrix[i][j]=1;
        			return new int[] {i,j};
        		}
        		count++;
        	}
        }
        return new int[] {0,0};
    }
    
    public void reset() {
    	size=m*n;
        for(int i=0;i<n;i++) {
        	Arrays.fill(matrix[i], 0);
        }
    }
}
