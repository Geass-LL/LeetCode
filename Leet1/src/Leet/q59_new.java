package Leet;

/*
 * �·�����ֱ��һȦһȦ����ȥ�ģ���һ��Ȧ��Ҫ4��ѭ����
 * ����������Ļ���ע��������û��������Ҫ�˹����ϡ�
 */
public class q59_new {
	public int[][] generateMatrix(int n){
		int rowstart=0,rowend=n-1;
		int colstart=0,colend=n-1;
		int alli=1,cur=0;
		int[][] res=new int[n][n];
		while(cur<Math.ceil(n/2)) {
			for(int i=rowstart;i<rowend;i++) {
				res[cur][i]=alli++;
			}
			for(int i=colstart;i<colend;i++) {
				res[i][n-1-cur]=alli++;
			}
			for(int i=rowend;i>rowstart;i--) {
				res[n-1-cur][i]=alli++;
			}
			for(int i=colend;i>colstart;i--) {
				res[i][cur]=alli++;
			}
			rowstart++;
			rowend--;
			colstart++;
			colend--;
			cur++;
		}	
		if(n%2!=0)
			res[cur][cur]=alli;
		return res;
	}
}
