package Leet;

import java.util.*;

public class q212 {
	/*
	 * 这一部分解法会超时。。。
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
	}*/
	/*
    private int[] dy = {-1, 1, 0, 0};
    private int[] dx = {0, 0, -1, 1};
    private void find(char[][] board, boolean[][] visit, int y, int x, Trie node, List<String> results) {
        if (y < 0 || y >= board.length || x < 0 || x >= board[y].length) return;
        if (visit[y][x]) return;
        visit[y][x] = true;
        Trie next = node.nexts[board[y][x]-'a'];
        if (next != null) {
            if (next.word != null) {
                results.add(next.word);
                next.word = null;
            }
            for(int i=0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                find(board, visit, ny, nx, next, results);
            }
        }
        visit[y][x] = false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for(String word: words) {
            Trie node = root;
            char[] wa = word.toCharArray();
            for(char c: wa) node = node.append(c);
            node.word = word;
        }
        boolean[][] visit = new boolean[board.length][board[0].length];
        List<String> results = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                find(board, visit, i, j, root, results);
            }
        }
        return new ArrayList<>(results);
    }
	class Trie {
	    String word;
	    Trie[] nexts = new Trie[26];
	    Trie append(char ch) {
	        if (nexts[ch-'a'] == null) nexts[ch-'a'] = new Trie();
	        return nexts[ch-'a'];
	    }
	}
	*/
	public List<String> findWords(char[][] board,String[] words){
		Trie root=new Trie();
		for(String word:words) {
			Trie node=root;
			char[] chs=word.toCharArray();
			for(char ch:chs) {
				if(node.next[ch-'a']==null) node.next[ch-'a']=new Trie();
				node=node.next[ch-'a'];
			}
			node.word=word;
		}
		int m=board.length,n=board[0].length;
		boolean[][] visited=new boolean[m][n];
		List<String> res=new ArrayList<String>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				find(board,visited,i,j,root,res);
			}
		}
		return res;
	}
	void find(char[][] board,boolean[][] visited,int i,int j,Trie root,List<String> res) {
		int[] di= {1,-1,0,0},dj={0,0,1,-1};
		if(i<0||i>=board.length||j<0||j>=board[0].length||visited[i][j]) return;
		visited[i][j]=true;
		char ch=board[i][j];
		Trie node=root.next[ch-'a'];
		if(node!=null) {
			if(node.word!=null)	{
				res.add(node.word);
				node.word=null;
			}
			for(int k=0;k<4;k++) {
				int ni=i+di[k];
				int nj=j+dj[k];
				find(board,visited,ni,nj,node,res);
			}
		}
		visited[i][j]=false;
	}
	class Trie{
		String word;
		Trie[] next;
		Trie(){
			this.word=null;
			next=new Trie[26];
		}
	}
}
