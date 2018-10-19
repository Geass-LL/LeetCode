package Leet;

import java.util.ArrayList;
import java.util.List;

public class q59 {
	public int[][] generateMatrix(int n) {
		int[][] res=new int[n][n];
		int alli=1;
		for(int i=0;i<Math.ceil(n/2.0);i++) {
			List<Integer> x=new ArrayList();
			List<Integer> y=new ArrayList();
			cacupos(x,y,i,n-1,n-1);
			res[i][i]=alli++;
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
							res[x.get(j)][tempi]=alli++;
						}
					}else {
						start=temp1-1;
						stop=temp2;
						for(int tempi=start;tempi>=stop;tempi--) {
							res[x.get(j)][tempi]=alli++;
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
							res[tempi][y.get(j)]=alli++;
						}
					}else {
						start=temp1-1;
						stop=temp2;
						for(int tempi=start;tempi>=stop;tempi--) {
							res[tempi][y.get(j)]=alli++;
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
