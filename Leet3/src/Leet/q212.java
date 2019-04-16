package Leet;

import java.util.*;

public class q212 {
	private boolean stop=false;
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res=new ArrayList<String>();
		if(board==null||board.length==0||board[0].length==0||words==null) return res;
		for(int i=0;i<words.length;i++) {
			boolean[][] visited=new boolean[board.length][board[0].length];
			String cur="";
			stop=false;
			btk(res,board,visited,words[i],cur,0,0);
		}
		return res;
    }
	void btk(List<String> res,char[][] board,boolean[][] visited,String s,String cur, int x, int y) {
		if(cur.length()==0) {
			List<List<Integer>> cho=find(board,s.charAt(0));
			for(int i=0;i<cho.size();i++) {
				int posx=cho.get(i).get(0),posy=cho.get(i).get(1);
				visited[posy][posx]=true;
				cur+=s.charAt(cur.length());
				btk(res,board,visited,s,cur,posx,posy);
				if(stop) return;
				cur=cur.substring(0,cur.length()-1);
				visited[posy][posx]=false;
			}
		}else if(cur.length()<s.length()) {
			List<List<Integer>> cho=find(board,visited,x,y,s.charAt(cur.length()));
			for(int i=0;i<cho.size();i++) {
				int posx=cho.get(i).get(0),posy=cho.get(i).get(1);
				visited[posy][posx]=true;
				cur+=s.charAt(cur.length());
				btk(res,board,visited,s,cur,posx,posy);
				if(stop) return;
				cur=cur.substring(0,cur.length()-1);
				visited[posy][posx]=false;
			}
		}else {
			res.add(cur);
			stop=true;
			return;
		}
	}
	List<List<Integer>> find(char[][] board,boolean[][] visited, int posx, int posy, char ch) {
		int m=board.length,n=board[0].length;
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(posx+1<n&&!visited[posy][posx+1]&&board[posy][posx+1]==ch) {
			List<Integer> temp=new ArrayList<Integer>();
			temp.add(posx+1);
			temp.add(posy);
			res.add(temp);
		}
		if(posx-1>=0&&!visited[posy][posx-1]&&board[posy][posx-1]==ch) {
			List<Integer> temp=new ArrayList<Integer>();
			temp.add(posx-1);
			temp.add(posy);
			res.add(temp);
		}
		if(posy+1<m&&!visited[posy+1][posx]&&board[posy+1][posx]==ch) {
			List<Integer> temp=new ArrayList<Integer>();
			temp.add(posx);
			temp.add(posy+1);
			res.add(temp);
		}
		if(posy-1>=0&&!visited[posy-1][posx]&&board[posy-1][posx]==ch) {
			List<Integer> temp=new ArrayList<Integer>();
			temp.add(posx);
			temp.add(posy-1);
			res.add(temp);
		}
		return res;
	}
	List<List<Integer>> find(char[][] board,char ch){
		int m=board.length,n=board[0].length;
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j]==ch) {
					List<Integer> temp=new ArrayList<Integer>();
					temp.add(j);
					temp.add(i);
					res.add(temp);
				}
			}
		}
		return res;
	}
}
