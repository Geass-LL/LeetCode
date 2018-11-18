package Leet;

/*
 * 需要保存最低值和最大收益。
 */

public class q121 {
	public int maxProfit(int[] prices) {
		if(prices.length==0)
			return 0;
		int minnum=prices[0],res=0;
		for(int i=0;i<prices.length;i++) {
			if(prices[i]<minnum) {
				minnum=prices[i];
			}
			if(prices[i]-minnum>res) {
				res=prices[i]-minnum;
			}
		}
		return res;
    }
}
