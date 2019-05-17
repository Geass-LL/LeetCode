package Leet;

public class q279 {
	public int numSquares(int n) {
		/*
		 * 动态规划的解法：有点过于暴力		
		int[] d=new int[n+1];
		if(n<=0)	return 0;
		d[1]=1;
		for(int i=2;i<=n;i++) {
			int sqrtv=(int) Math.sqrt(i);
			if(sqrtv*sqrtv==i) {
				d[i]=1;
			}else {
				int left=1,right=i-1;
				int temp=i;
				while(left<=right) {
					temp=Math.min(temp, d[left]+d[right]);//递归表达式
					left++;
					right--;
				}
				d[i]=temp;
			}
		}
		return d[n];
		 */
		//优化后的动态规划解法
		int[] d=new int[n+1];
		if(n<=0)	return 0;
		for(int i=0;i<=n;i++) {
			d[i]=i;
		}
		for(int i=0;i<=n;i++) {
			int j=1;
			while(i+j*j<=n) {
				d[i+j*j]=Math.min(d[i+j*j], d[i]+1);//重要！即：
													//以i为起点，他加上平方数的位置，其值一定不大于i处值+1！
				j++;
			}
		}
		return d[n];
    }
}
