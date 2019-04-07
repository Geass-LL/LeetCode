package Leet;

/*
 * 就是看m和n左边的相同部分；
 * 一直右移，直到左边相同；
 * 将此时的值左移相同位数返回。
 */


public class q201 {
    public int rangeBitwiseAnd(int m, int n) {
        int i=0;
        while(m!=n) {
        	m>>=1;
        	n>>=1;
        	i++;
        }
        return m<<i;
    }
}