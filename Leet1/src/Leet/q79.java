package Leet;

import java.util.*;

/*
 * 一次成功，虽然代码实现的有点挫。主要还是根据当前的状态生成待选择的解是回溯法的大难点；
 * 解决了这个问题，回溯法就是套框架的问题了。
 */
public class q79 {
	public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
		int[][] valid=new int[m][n];
		boolean res=btk(board,valid,word,0,0,true);
		return res;
    }
	boolean btk(char[][] board,int[][] valid,String word,int msel,int nsel,boolean isfirst) {
		List<Integer> mnum=new ArrayList<Integer>(),nnum=new ArrayList<Integer>();
		if(word.length()==0) {
			return true;
		}else {
			char curchar=word.charAt(0);
			searchchar(board,valid,curchar,mnum,nnum,msel,nsel,isfirst);//生成可能的可行解。注意：头部可以是全局查找，但是一旦头部找到，后续就从上下左右查找了；
			int cacnlength=mnum.size();
			if(cacnlength==0) {
				return false;
			}else {
				for(int i=0;i<cacnlength;i++) {
					valid[mnum.get(i)][nnum.get(i)]=1;//维护valid
					if(btk(board,valid,word.substring(1, word.length()),mnum.get(i),nnum.get(i),false))
						return true;//如果返回true，直接返回true
					else//否则尝试下一条路径。
						valid[mnum.get(i)][nnum.get(i)]=0;
				}
				return false;
			}
		}
	}
	void searchchar(char[][] board,int[][] valid,char target,List<Integer> mnum,List<Integer> nnum,int msel,int nsel,boolean isfirst) {
		int m=board.length,n=board[0].length;
		if(isfirst) {
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(board[i][j]==target&&valid[i][j]==0) {
						mnum.add(i);
						nnum.add(j);
					}
				}
			}
		}else {
			if(msel+1<m) {
				if(board[msel+1][nsel]==target&&valid[msel+1][nsel]==0) {
					mnum.add(msel+1);
					nnum.add(nsel);
				}
			}
			if(msel-1>=0) {
				if(board[msel-1][nsel]==target&&valid[msel-1][nsel]==0) {
					mnum.add(msel-1);
					nnum.add(nsel);
				}
			}
			if(nsel+1<n) {
				if(board[msel][nsel+1]==target&&valid[msel][nsel+1]==0) {
					mnum.add(msel);
					nnum.add(nsel+1);
				}
			}
			if(nsel-1>=0) {
				if(board[msel][nsel-1]==target&&valid[msel][nsel-1]==0) {
					mnum.add(msel);
					nnum.add(nsel-1);
				}
			}
		}
	}
}









