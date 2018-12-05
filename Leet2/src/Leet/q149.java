package Leet;

import java.awt.Point;

/*
 * accept����˼·��
 * �����������γɵĿ����ԣ�����oridx*dy==oridy*dx�ж������Ƿ��ߣ���ȥ�߽߱ǽǵ����ѡ�
 * overlap���غϵ����˼�������˵㣬���ս����������������
 * ��ע�⡿oridx,oridy,dx,dy����Long���͡�
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
