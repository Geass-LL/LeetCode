package Leet;

import java.util.*;

public class q130 {
	public void solve(char[][] board) {
		Queue<Integer> queue=new LinkedList<Integer>();
        if(board.length==0||board[0].length==0) {
        	return;
        }
        int height=board.length,length=board[0].length;
        for(int i=0;i<length;i++) {
        	if(board[0][i]=='O') {
        		queue.add(0);
        		queue.add(i);
        		helper(queue,board);
        	}
        	if(board[height-1][i]=='O') {
        		queue.add(height-1);
        		queue.add(i);
        		helper(queue,board);
        	}
        }
        for(int j=1;j<height-1;j++) {
        	if(board[j][0]=='O') {
        		queue.add(j);
        		queue.add(0);
        		helper(queue,board);
        	}
        	if(board[j][length-1]=='O') {
        		queue.add(j);
        		queue.add(length-1);
        		helper(queue,board);
        	}
        }
        for(int i=0;i<height;i++) {
        	for(int j=0;j<length;j++) {
        		if(board[i][j]=='.') {
        			board[i][j]='O';
        		}else if(board[i][j]=='O') {
        			board[i][j]='X';
        		}
        	}
        }
    }
	void helper(Queue<Integer> queue,char[][] board) {
		int height=board.length,length=board[0].length;
		while(!queue.isEmpty()) {
			int heighti=queue.poll(),lengthi=queue.poll();
			board[heighti][lengthi]='.';
			if(heighti-1>=0&&board[heighti-1][lengthi]=='O') {
				queue.add(heighti-1);
				queue.add(lengthi);
				board[heighti-1][lengthi]='.';
			}
			if(heighti+1<height&&board[heighti+1][lengthi]=='O') {
				queue.add(heighti+1);
				queue.add(lengthi);
				board[heighti+1][lengthi]='.';
			}
			if(lengthi-1>=0&&board[heighti][lengthi-1]=='O') {
				queue.add(heighti);
				queue.add(lengthi-1);
				board[heighti][lengthi-1]='.';
			}
			if(lengthi+1<length&&board[heighti][lengthi+1]=='O') {
				queue.add(heighti);
				queue.add(lengthi+1);
				board[heighti][lengthi+1]='.';
			}
		}
	}
}
