package Leet;

/*
 * 调用Onenote中提到的框架，效果不错。
 * 
 */
public class q37 {
	public void solveSudoku(char[][] board) {
		char[][] result=new char[9][9];
		//从-1开始，因为刚开始有j++
		btk(board,0,-1);
		//showboard(board);
    }
	void btk(char[][] board,int i,int j) {
		//如果深度满足要求，则返回，对这一解进行处理，这里什么也不做，直接返回。
		if(i==8&&j==8) {
			//showboard(board);
			return;
		}else {
			//深度的递增
			j++;
			if(j==9) {
				j=0;
				i++;
			}
			if(board[i][j]=='.') {
				//待测试解的范围
				int[] candidate=validvalue(board,i,j);
				for(int eachcan:candidate) {
					board[i][j]=String.valueOf(eachcan).charAt(0);
					btk(board,i,j);
					//确保得到一个解之后就不再回退了，如需要多个解则下面这句话去掉。
					if(over(board))
						return;
					board[i][j]='.';
				}
			}else {
				btk(board,i,j);
			}
		}
	}
	boolean over(char[][] board) {
		for(int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				if(board[i][j]=='.')
					return false;
			}
		}
		return true;
	}
	int[] validvalue(char[][] board,int curi,int curj) {
		int[] temp=new int[9];
		for (int i=0;i<9;i++) {
			if(board[i][curj]!='.') {
				temp[Integer.valueOf(board[i][curj])-Integer.valueOf('1')]=1;
			}
			if(board[curi][i]!='.') {
				temp[Integer.valueOf(board[curi][i])-Integer.valueOf('1')]=1;
			}
			if(board[curi/3*3+i/3][curj/3*3+i%3]!='.') {
				temp[Integer.valueOf(board[curi/3*3+i/3][curj/3*3+i%3])-Integer.valueOf('1')]=1;
			}
		}
		int length=9;
		for(int i=0;i<9;i++) {
			length-=temp[i];
		}
		int[] res=new int[length];
		int j=0;
		for(int i=0;i<9;i++) {
			if(temp[i]==0) {
				res[j++]=i+1;
			}
		}
		return res;
	}
	void showboard(char[][] board) {
		for(int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
