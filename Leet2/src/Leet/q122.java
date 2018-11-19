package Leet;

/*
 * ÕÇÇ°Âò£¬µøÇ°Âô¡£
 */

public class q122 {
	public int maxProfit(int[] prices) {
		int buy=0,sell=0,res=0,state=0,length=prices.length;
		for(int i=0;i<length-1;i++) {
			if(prices[i+1]-prices[i]>0&&state==0) {
				buy=prices[i];
				state=1;
			}
			if(prices[i+1]-prices[i]<0&&state==1) {
				sell=prices[i];
				state=0;
				res+=(sell-buy);
			}
		}
		if(state==1) res+=prices[length-1]-buy;
		return res;
    }
}
