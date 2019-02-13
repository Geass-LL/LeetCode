package Leet;

/*
 * 在阶乘中，由于2的数量多于5的数量，末尾0的个数其实是限制于因式分解后5的个数的。
 * 5：1
 * 10：2
 * 15：3
 * 20：4
 * 25：6，这由于25包含两个5，加上的值为2；
 * 30：7，
 * 以此类推；
 */

public class q172 {
	public int trailingZeroes(int n) {
		int res=0;
        while(n>=5){
            res+=n/5;
            n/=5;
        }
        return res;
    }
}
