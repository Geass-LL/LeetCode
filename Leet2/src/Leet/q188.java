package Leet;

/*
 * 参考了博客：https://blog.csdn.net/qq508618087/article/details/51678245
 * 将原来的cpp代码修改为java代码。
 * 状态转移方程还是不太懂啊。
 */

public class q188 {
	public int maxProfit(int k, int[] prices) {
		if(prices.length==0) return 0;
		int length=prices.length,res=0;
		if(k>=length/2) {
			for(int i=1;i<length;i++) {
				if(prices[i]-prices[i-1]>0)
					res+=prices[i]-prices[i-1];
			}
			return res;
		}
		int[] buy=new int[k+1],sell=new int[k+1];
		for(int i=0;i<=k;i++) {
			buy[i]=Integer.MIN_VALUE;
		}
		for(int val:prices) {
			for(int i=1;i<=k;i++) {
				buy[i]=Math.max(sell[i-1]-val, buy[i]);
				sell[i]=Math.max(buy[i]+val, sell[i]);
			}
		}
		return sell[k];
    }
}
