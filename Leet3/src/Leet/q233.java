package Leet;

/*
 * 如6527：
 * 个位的1：十位后+个位前(>=2:1								652+1(7>=2)
 * 						(<1 :0
 * 						(其他:1
 * 十位的1：百位后*10+十位前(>=20:10							65*10+10(27>=20)
 * 						   (<10:0
 * 						   (其他:十位前-9
 * 百位的1：千位后*100+百位前(>=200:100						6*100+100(527>=200)
 * 							(<100:0
 * 							(其他:百位前-99
 * 依次类推
 */

public class q233 {
	public int countDigitOne(int n) {
		if(n<=0)	return 0;
		long res=0,temp=1;//这里注意用long，不然会超出。
		while(n>=temp) {
			long left=n/(temp*10),right=n%(temp*10);//left为加号的前半部分，right为加号的后半部分
			if(temp==1) {
				res+=left;
				res+=right>=1?1:0;//个位的比较特殊
			}else {
				res+=left*temp;
				if(right>=2*temp) {
					res+=temp;
				}else {
					res+=right>=temp?(right-temp+1):0;
				}
			}
			temp*=10;
		}
		return (int)res;
    }
}
