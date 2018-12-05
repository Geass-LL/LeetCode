package Leet;

import java.awt.Point;

/*
 * accept代码思路：
 * 遍历三个点形成的可能性，根据oridx*dy==oridy*dx判断三点是否共线，免去边边角角的困难。
 * overlap是重合点的意思，跳过此点，最终结果加上跳过次数。
 * 【注意】oridx,oridy,dx,dy都是Long类型。
 */

public class q149 {
	public int maxPoints(Point[] points) {
		int length=points.length;
		if(length<2) return length;
		int  curcount=0,res=2,overlap=0;
		int oridx=0,oridy=0,dx=0,dy=0;
		for(int i=0;i<length;i++) {
			for(int j=i+1;j<length;j++) {
				curcount=1;
				oridx=points[j].x-points[i].x;
				oridy=points[j].y-points[i].y;
				if(oridx==0&&oridy==0) {
					overlap++;
				}else {
					curcount++;
					for(int k=j+1;k<length;k++) {
						dx=points[k].x-points[k].x;
						dy=points[k].y-points[k].y;
						if(oridx*dy==oridy*dx) {
							curcount++;
						}
					}
				}
				res=Math.max(res, curcount+overlap);
			}
			overlap=0;
		}
		return res;
    }
}
