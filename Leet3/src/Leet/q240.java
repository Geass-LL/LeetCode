package Leet;

/*
 * 主要是注意到是一直与右上角比较，不是采用二分搜索的方法。
 */

public class q240 {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int m=matrix.length,n=matrix[0].length;
        int curi=0,curj=n-1;
        while(curi>=0&&curi<m&&curj>=0&&curj<n){
            if(matrix[curi][curj]==target)  return true;
            else if(matrix[curi][curj]<target){
                curi++;
            }else{
                curj--;
            }
        }
        return false;
    }
}
