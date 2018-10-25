package Leet;

public class q69 {
	public int mySqrt(int x) {
        int left=0,right=x;
        double mid=0,product=0;
        while(left<=right) {
        	mid=(left+right)/2;
        	product=mid*mid;
        	if(product==x)
        		return (int)mid;
        	else if(product<x)
        		left=(int)mid+1;
        	else
        		right=(int)mid-1;
        }
        if(product>x)
        	return (int)mid-1;
        return (int)mid;
    }
}
