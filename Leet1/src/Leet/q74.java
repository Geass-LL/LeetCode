package Leet;

/*
 * 先查行，再查列，mad好像并没有直接化成一行查的快。
 */
public class q74 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0||matrix==null)
			return false;
		int m=matrix.length,n=matrix[0].length;
		if(n==0)
			return false;
		int left=0,right=m-1,mid=0,sel;
		while(left<=right) {
			mid=(left+right)/2;
			if(matrix[mid][0]>target)
				right=mid-1;
			else if(matrix[mid][0]<target)
				left=mid+1;
			else
				return true;
		}
        if(matrix[mid][0]>target)
            if(mid>0)   sel=mid-1;
            else return false;
        else
            sel=mid;
		left=0;
		right=n-1;
		while(left<=right) {
			mid=(left+right)/2;
			if(matrix[sel][mid]<target)
				left=mid+1;
			else if(matrix[sel][mid]>target)
				right=mid-1;
			else
				return true;
		}
		return false;
    }
}
