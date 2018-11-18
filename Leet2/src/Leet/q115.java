package Leet;

/*
 * 参考了博客的d[i][j]的定义，然后自己实现出来。具体见Onenote。
 * 根据t是否存在重复的情况分两种，不重复：
 * d[i][j]=d[i-1][j]+d[i][j-1]
 * 重复：
 * d[i][j]=d[i-1][j]+d[i-1][j-1]
 */

public class q115 {
	public int numDistinct(String s, String t) {
		int slength=s.length(),tlength=t.length();
		if(slength==0||tlength==0)
			return 0;
		int[][] res=new int[slength][tlength];
		if(s.charAt(0)==t.charAt(0))
			res[0][0]=1;
		for(int i=1;i<slength;i++) {
			res[i][0]=(s.charAt(i)==t.charAt(0))?res[i-1][0]+1:res[i-1][0];
		}
		for(int j=1;j<tlength;j++) {
			for(int i=j;i<slength;i++) {
				if(s.charAt(i)==t.charAt(j)) {
					res[i][j]=(t.charAt(j)==t.charAt(j-1))?(res[i-1][j]+res[i-1][j-1]):(res[i-1][j]+res[i][j-1]);
				}else {
					res[i][j]=res[i-1][j];
				}
			}
		}
		return res[slength-1][tlength-1];
    }
}
