package Leet;

/*
 * 这个题不能单纯递归，需要用二分法减小计算量。
 */
public class q50 {
	public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        int t=n/2;
        if(n<0) {
        	t=-t;
        	x=1/x;
        }
        double res=myPow(x,t);
        if(n%2==0) return res*res;
        return res*res*x;
    }
}
