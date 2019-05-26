package Main;

import java.util.*;

public class Bit3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int height=sc.nextInt(),length=sc.nextInt();
		int[][] grid=new int[height][length];
		for(int i=0;i<height;i++) {
			for(int j=0;j<length;j++) {
				grid[i][j]=sc.nextInt();
				System.out.println(grid[i][j]);
			}
		}
		int res=0;
		int[][] visited=new int[height][length];
		Queue<Integer> iq=new LinkedList<Integer>(),jq=new LinkedList<Integer>();
		for(int i=0;i<height;i++) {
			for(int j=0;j<length;j++) {
				if(grid[i][j]==1&&visited[i][j]==0) {
					if(iq.isEmpty()) {
						iq.add(i);
						jq.add(j);
						visited[i][j]=1;
						res++;
					}
					while(!iq.isEmpty()) {
						int icur=iq.poll(),jcur=jq.poll();
						if(icur<height-1&&grid[icur+1][jcur]==1&&visited[icur+1][jcur]==0) {
							iq.add(icur+1);
							jq.add(jcur);
							visited[icur+1][jcur]=1;
						}
						if(jcur<length-1&&grid[icur][jcur+1]==1&&visited[icur][jcur+1]==0) {
							iq.add(icur);
							jq.add(jcur+1);
							visited[icur][jcur+1]=1;
						}
						if(icur>0&&grid[icur-1][jcur]==1&&visited[icur-1][jcur]==0) {
							iq.add(icur-1);
							jq.add(jcur);
							visited[icur-1][jcur]=1;
						}
						if(jcur>0&&grid[icur][jcur-1]==1&&visited[icur][jcur-1]==0) {
							iq.add(icur);
							jq.add(jcur-1);
							visited[icur][jcur-1]=1;
						}
						if(icur<height-1&&jcur<length-1&&grid[icur+1][jcur+1]==1&&visited[icur+1][jcur+1]==0) {
							iq.add(icur+1);
							jq.add(jcur+1);
							visited[icur+1][jcur+1]=1;
						}
						if(icur<height-1&&jcur>0&&grid[icur+1][jcur-1]==1&&visited[icur+1][jcur-1]==0) {
							iq.add(icur+1);
							jq.add(jcur-1);
							visited[icur+1][jcur-1]=1;
						}
						if(icur>0&&jcur<length-1&&grid[icur-1][jcur+1]==1&&visited[icur-1][jcur+1]==0) {
							iq.add(icur-1);
							jq.add(jcur+1);
							visited[icur-1][jcur+1]=1;
						}
						if(icur>0&&jcur>0&&grid[icur-1][jcur-1]==1&&visited[icur-1][jcur-1]==0) {
							iq.add(icur-1);
							jq.add(jcur-1);
							visited[icur-1][jcur-1]=1;
						}
					}
				}
			}
		}
		System.out.println(res);
	}
}
