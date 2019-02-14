package Leet;

public class q174 {
	public int calculateMinimumHP(int[][] dungeon) {
		int height=dungeon.length,length=dungeon[0].length;
		int res[][]=new int[height+1][length+1];
		res[height-1][length]=1;
		res[height][length-1]=1;
		for(int i=height-2;i>=0;i--) {
			res[i][length]=Integer.MAX_VALUE;
		}
		for(int j=length-2;j>=0;j--) {
			res[height][j]=Integer.MAX_VALUE;
		}
		for(int i=height-1;i>=0;i--) {
			for(int j=length-1;j>=0;j--) {
				res[i][j]=Math.max(1, Math.min(res[i+1][j], res[i][j+1])-dungeon[i][j]);
			}
		}
		return res[0][0];
    }
}
