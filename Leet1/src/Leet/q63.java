package Leet;
/*
 * 和上一个题一样，区别在如果碰到障碍将障碍处的值改为0；其他正常迭代。
 * 注意：最上边和最右边，只要碰到障碍，后面的就全部为0，当然初始化的时候就是0所以不需要做出修改。
 */
public class q63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m=obstacleGrid.length,n=obstacleGrid[0].length;
    	int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==0)
                res[i][0]=1;
            else{
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==0)
                res[0][i]=1;
            else{
                break;
            }
        }
    	for(int i=1;i<m;i++) {
    		for(int j=1;j<n;j++) {
    			if(obstacleGrid[i][j]==0)
    				res[i][j]=res[i-1][j]+res[i][j-1];
    			else
    				res[i][j]=0;
    		}
    	}
    	return res[m-1][n-1];
    }
}
