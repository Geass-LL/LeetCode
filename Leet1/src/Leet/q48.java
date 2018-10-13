package Leet;
/*
 * 根据旋转公式，化简可得：
 * x'=y
 * y'=n-x
 * 虽然如此，赋值的时候，应该是倒过来的。
 */
public class q48{
    public void rotate(int[][] matrix) {
    	int length=matrix.length;
    	for(int i=0;i<length/2;i++) {
    		for(int j=i+1;j<length-i;j++) {
    			int temp=matrix[i][j];
    			matrix[i][j]=matrix[length-1-j][i];
    			matrix[length-1-j][i]=matrix[length-1-i][length-1-j];
    			matrix[length-1-i][length-1-j]=matrix[j][length-1-i];
    			matrix[j][length-1-i]=temp;
    		}
    	}
    }
}
