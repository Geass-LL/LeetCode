package Leet;

public class q260 {
	public int[] singleNumber(int[] nums) {
		int xorvalue=0;
		for(int num:nums) {
			xorvalue^=num;
		}
		int a=xorvalue,b=xorvalue,mask=1;
		while((mask&xorvalue)==0) {
			mask<<=1;
		}
		for(int num:nums) {
			if((mask&num)==0) {
				a^=num;
			}else {
				b^=num;
			}
		}
		return new int[] {a,b};
    }
}
