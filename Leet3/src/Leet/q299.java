package Leet;

public class q299 {
	public String getHint(String secret, String guess) {
		char[] secretchs=secret.toCharArray(),guesschs=guess.toCharArray();
		int[] maps=new int[10],mapg=new int[10];
		int countA=0,countB=0;
		for(int i=0;i<secretchs.length;i++) {
			if(guesschs[i]==secretchs[i]) {
				countA++;
			}else {
				mapg[guesschs[i]-'0']++;
				maps[secretchs[i]-'0']++;
			}
		}
		for(int i=0;i<10;i++) {
			countB+=Math.min(maps[i],mapg[i]);
		}
		return String.valueOf(countA)+"A"+String.valueOf(countB)+"B";
    }
}
