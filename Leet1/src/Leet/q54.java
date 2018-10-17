package Leet;

import java.util.*;
/*
 * 垃圾问题，一点技术含量也没有！！！
 * 但是修修补补的工作是真的烦。
 */
public class q54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res=new ArrayList();
		int m=matrix.length;
		int n=matrix[0].length;
		for(int i=0;i<Math.ceil(Math.min(m,n)/2.0);i++) {
			List<Integer> x=new ArrayList();
			List<Integer> y=new ArrayList();
			cacupos(x,y,i,m-1,n-1);
			for(int xi=0;xi<x.size();xi++) {
				System.out.print(x.get(xi));
				System.out.print(",");
				System.out.print(y.get(xi));
				System.out.print(" ");
			}
			System.out.println();
			res.add(matrix[i][i]);
			System.out.print(matrix[i][i]);
			System.out.print(" ");
			for(int j=0;j<x.size()-1;j++) {
				if(x.get(j)==x.get(j+1)) {
					int temp1=y.get(j);
					int temp2=y.get(j+1);
					int start=0;
					int stop=0;
					if(temp1<temp2) {
						start=temp1+1;
						stop=temp2;
						for(int tempi=start;tempi<=stop;tempi++) {
							res.add(matrix[x.get(j)][tempi]);
							System.out.print(matrix[x.get(j)][tempi]);
							System.out.print(" ");
						}
					}else {
						start=temp1-1;
						stop=temp2;
						for(int tempi=start;tempi>=stop;tempi--) {
							res.add(matrix[x.get(j)][tempi]);
							System.out.print(matrix[x.get(j)][tempi]);
							System.out.print(" ");
						}
					}
				}
				if(y.get(j)==y.get(j+1)) {
					int temp1=x.get(j);
					int temp2=x.get(j+1);
					int start=0;
					int stop=0;
					if(temp1<temp2) {
						start=temp1+1;
						stop=temp2;
						for(int tempi=start;tempi<=stop;tempi++) {
							res.add(matrix[tempi][y.get(j)]);
							System.out.print(matrix[tempi][y.get(j)]);
							System.out.print(" ");
						}
					}else {
						start=temp1-1;
						stop=temp2;
						for(int tempi=start;tempi>=stop;tempi--) {
							res.add(matrix[tempi][y.get(j)]);
							System.out.print(matrix[tempi][y.get(j)]);
							System.out.print(" ");
						}
					}
				}
			}
		}
		return res;
    }
	void cacupos(List<Integer> x,List<Integer> y,int start,int inm,int inn) {
		x.add(start);
		y.add(start);
		if(inn-start>start) {
			x.add(start);
			y.add(inn-start);
			if(inm-start>start) {
				x.add(inm-start);
				y.add(inn-start);
			}
		}
		if(inm-start>start) {
			x.add(inm-start);
			y.add(start);
		}
		if(start+1<inm-start&&inn-start!=start) {
			x.add(start+1);
			y.add(start);
		}
	}
}
