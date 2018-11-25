package Leet;

/*
 * 生硬的算法，这个效率也太低了点儿吧。
 * 用res[i][j]表示从i到j的最小切割次数；
 * 每次迭代如果碰到字母相同的，如果其内部回文则为0；否则尝试每一个可能的切割点。
 */

public class q132 {
	public int minCut(String s) {
		int length=s.length();
		if(length<=1) return 0;
		int[][] res=new int[length][length];
		res[0][0]=0;
		char[] chas=s.toCharArray();
		for(int j=1;j<length;j++) {
			char cur=chas[j];
			for(int i=j-1;i>=0;i--) {
				if(i==j-1) {
					if(cur==chas[i]) res[i][j]=0;//如果其内部回文则为0；
					else res[i][j]=1;
				}else {
					if(cur==chas[i]&&res[i+1][j-1]==0){//如果其内部回文则为0；
						res[i][j]=0;
					}else {
						int minlength=Integer.MAX_VALUE;
						for(int k=i;k<j;k++) {//否则尝试每一个可能的切割点。
							if(res[i][k]+res[k+1][j]+1<minlength)
								minlength=res[i][k]+res[k+1][j]+1;
						}
						res[i][j]=minlength;
					}
				}
			}
		}
		return res[0][length-1];
    }
}
