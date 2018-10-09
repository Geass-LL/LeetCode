package Leet;

/*
 * ����Onenote���ᵽ�Ŀ�ܣ�Ч������
 * 
 */
public class q37 {
	public void solveSudoku(char[][] board) {
		char[][] result=new char[9][9];
		//��-1��ʼ����Ϊ�տ�ʼ��j++
		btk(board,0,-1);
		//showboard(board);
    }
	void btk(char[][] board,int i,int j) {
		//����������Ҫ���򷵻أ�����һ����д�������ʲôҲ������ֱ�ӷ��ء�
		if(i==8&&j==8) {
			//showboard(board);
			return;
		}else {
			//��ȵĵ���
			j++;
			if(j==9) {
				j=0;
				i++;
			}
			if(board[i][j]=='.') {
				//�����Խ�ķ�Χ
				int[] candidate=validvalue(board,i,j);
				for(int eachcan:candidate) {
					board[i][j]=String.valueOf(eachcan).charAt(0);
					btk(board,i,j);
					//ȷ���õ�һ����֮��Ͳ��ٻ����ˣ�����Ҫ�������������仰ȥ����
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
