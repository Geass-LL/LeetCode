package Leet;

/*
 * 很有意思的一个题目，见Onenote
 */

public class q289 {
	public void gameOfLife(int[][] board) {
		if(board==null||board.length==0||board[0].length==0)	return;
		int m=board.length,n=board[0].length;
		int[] dx= {-1,0,1,-1,1,-1,0,1},dy= {-1,-1,-1,0,0,1,1,1};
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				int count=0;
				for(int k=0;k<8;k++) {
					if(i+dx[k]<m&&i+dx[k]>=0&&j+dy[k]<n&&j+dy[k]>=0) {
						if(board[i+dx[k]][j+dy[k]]==1||board[i+dx[k]][j+dy[k]]==2) {
							count++;
						}
					}
				}
				if(board[i][j]==0) {
					if(count==3)	board[i][j]=3;
				}else {
					if(count<2||count>3)	board[i][j]=2;
				}
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				board[i][j]=((board[i][j]&1)==0)?0:1;
			}
		}
    }
}
