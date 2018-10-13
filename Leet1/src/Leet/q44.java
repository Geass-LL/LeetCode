package Leet;
/*
 * 不会写，抄的大神的文章。把C++转换成Java
 * https://blog.csdn.net/Bendaai/article/details/80141026
 */
public class q44 {
	public boolean isMatch(String s, String p) {
        boolean[][] dyp=new boolean[1000][1000];
        dyp[0][0]=true;
        for(int i=1;i<s.length();i++) {
        	dyp[i][0]=false;
        }
        for(int i=1;i<p.length();i++) {
        	dyp[0][i]=(p.charAt(i-1)=='*')&&(dyp[0][i-1]);
        }
        for(int j=1;j<=p.length();j++){
        	for(int i=1;i<=s.length();i++) {
        		if(p.charAt(j-1)!='*')
        			dyp[i][j]=dyp[i-1][j-1]&&(p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='?');
        		else
        			dyp[i][j]=dyp[i-1][j]||dyp[i][j-1];
        	}
        }
        return dyp[s.length()][p.length()];
    }
}
