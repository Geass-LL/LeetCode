package Main;

public class In1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=8123;
		double[] d=new double[n+1];
		d[0]=0;
		d[1]=1;
		d[2]=1;
		double temp=1;
		for(int i=3;i<=n;i++) {
			d[i]=1+2.0/i*temp;
			temp+=d[i-1];
		}
		System.out.println(d[n]);
		double[] dp=new double[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=1;
		double sum=1;
		for(int i=3;i<=n;i++) {
			if((i&1)==1)
	            dp[i] = (sum-dp[(i-3)>>1]+i/2)*2/i + (1+2*dp[(i-3)>>1])/i;
	        else
	            dp[i] = (sum+(i>>1))/(i>>1);
	        sum += dp[i-1];
		}
		System.out.println(dp[n]);
	}

}
