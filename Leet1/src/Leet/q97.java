package Leet;
/*
 * 开心，开心，开心。
 * 见Onenote
 */
public class q97 {
	public boolean isInterleave(String s1, String s2, String s3) {
		int length1=s1.length(),length2=s2.length(),length3=s3.length();
		if(length1+length2!=length3)
			return false;
		boolean[][] res=new boolean[length1+1][length2+1];
		res[0][0]=true;
		for(int i=1;i<=length1;i++) {
			res[i][0]=res[i-1][0]&&(s3.charAt(i-1)==s1.charAt(i-1));
		}
		for(int j=1;j<=length2;j++) {
			res[0][j]=res[0][j-1]&&(s3.charAt(j-1)==s2.charAt(j-1));
		}
		for(int i=1;i<=length1;i++) {
			for(int j=1;j<=length2;j++) {
				res[i][j]=res[i-1][j]&&(s3.charAt(i+j-1)==s1.charAt(i-1))||
							res[i][j-1]&&(s3.charAt(i+j-1)==s2.charAt(j-1));
			}
		}
		return res[length1][length2];
    }
}
