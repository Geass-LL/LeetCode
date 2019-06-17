package Leet;

public class q326 {
	public boolean isPowerOfThree(int n) {
		return n>0?(1162261467%n==0):false;
    }
	/*
	 * 注意这里输入的是一个int类型，那就很好说了，所有的3的幂其质因数都是3，那么它一定可以被int中最大的3的倍数
	 * 整除，否则返回false。
	 */
}
