package Leet;

public class q70 {
	public int climbStairs(int n) {
		if(n==0) return 0;
        int[] res=new int[n];
        res[0]=1;
        if(n>1)
        	res[1]=2;
        for(int i=2;i<n;i++) {
        	res[i]=res[i-1]+res[i-2];
        }
        return res[n-1];
    }
}
