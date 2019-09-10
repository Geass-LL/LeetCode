package Leet;

import java.util.*;

public class q329 {
	public int maxlength=0;
	public int curmax=0;
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
		int height=matrix.length,length=matrix[0].length;
		int[][] dis=new int[height][length];
		int res=0;
		for(int i=0;i<height;i++) {
			for(int j=0;j<length;j++) {
				if(dis[i][j]==0) {
					res=Math.max(res, startdis(matrix,dis,i,j));
					curmax=0;
					maxlength=0;
				}
			}
		}
		return res;
    }
	int startdis(int[][] matrix,int[][] dis,int starti,int startj) {
		List<Pair> res=new ArrayList<Pair>(),tempres=new ArrayList<Pair>();
		tempres.add(new Pair(starti,startj));
		help(matrix,dis,starti,startj,res,tempres);
		updatedis(dis,res,curmax);
		return res.size()+curmax;
	}
	void help(int[][] matrix,int[][] dis,int i,int j,List<Pair> res,List<Pair> tempres) {
		List<Pair> cans=cand(matrix,i,j);
		if(cans.size()>0) {
			for(Pair each:cans) {
				i=each.x;
				j=each.y;
				if(dis[i][j]==0) {
					tempres.add(each);
					help(matrix,dis,i,j,res,tempres);
					tempres.remove(tempres.size()-1);
				}else {
					if(tempres.size()+dis[i][j]>maxlength) {
						curmax=dis[i][j];
						maxlength=tempres.size()+dis[i][j];
						res.clear();
						for(Pair each1:tempres) {
							res.add(each1);
						}
					}
				}
			}
		}else {
			if(tempres.size()+dis[i][j]>maxlength) {
				curmax=dis[i][j];
				maxlength=tempres.size()+dis[i][j];
				res.clear();
				for(Pair each:tempres) {
					res.add(each);
				}
			}
		}
	}
	List<Pair> cand(int[][] matrix,int i,int j) {
		List<Pair> cans=new ArrayList<Pair>();
		if(i-1>=0&&matrix[i-1][j]>matrix[i][j]) {
			cans.add(new Pair(i-1,j));
		}
		if(j-1>=0&&matrix[i][j-1]>matrix[i][j]) {
			cans.add(new Pair(i,j-1));
		}
		if(i+1<matrix.length&&matrix[i+1][j]>matrix[i][j]) {
			cans.add(new Pair(i+1,j));
		}
		if(j+1<matrix[0].length&&matrix[i][j+1]>matrix[i][j]) {
			cans.add(new Pair(i,j+1));
		}
		return cans;
	}
	void updatedis(int[][] dis,List<Pair> pairs,int value) {
		//value指以pairs的下一个点为起点的最大路径长度
		int length=pairs.size(),i=0;
		for(Pair each:pairs) {
			dis[each.x][each.y]=value+length-i;
			i++;
		}
	}
}
class Pair{
	public int x;
	public int y;
	public Pair(int inx,int iny) {
		x=inx;
		y=iny;
	}
}
