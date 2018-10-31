package Leet;
/*
 * 本来以为有点难的，掌握了方法就还好吧。
 */
public class q72 {
	public int minDistance(String word1, String word2) {
		int length1=word1.length(),length2=word2.length();
		if(length1==0 && length2==0)
			return 0;
		else if(length1==0)
			return length2;
		else if(length2==0)
			return length1;
		else {
			int[][] res=new int[length1+1][length2+1];
			for(int i=0;i<=length1;i++)
				res[i][0]=i;
			for(int i=0;i<=length2;i++)
				res[0][i]=i;
			for(int i=1;i<=length1;i++) {
				for(int j=1;j<=length2;j++) {
					if(word1.charAt(i-1)==word2.charAt(j-1)) {
						res[i][j]=res[i-1][j-1];
					}else {
						res[i][j]=Math.min(res[i-1][j-1],Math.min(res[i-1][j], res[i][j-1]))+1;
					}
				}
			}
			return res[length1][length2];
		}
    }
}
