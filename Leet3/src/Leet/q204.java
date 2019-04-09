package Leet;

import java.util.*;

/*
 * 需要注意两点：
 * 对于一个质数，在填坑时，从它的平方开始，但是要注意越界问题；
 * 不要用哈希表结构会超时，用boolean数组就ok。
 */

public class q204 {
	public int countPrimes(int n) {
		if(n<=2) return 0;
		int res=0;
		boolean[] map=new boolean[n];
		int start=2;
		while(start<n) {
			if(!map[start]) {
				res++;
				int i=start;
				while(start*i<n&&start<Math.sqrt(n)) {
					if(!map[start*i]) {
						map[start*i]=true;
					}
					i++;
				}
			}
			start++;
		}
		return res;
    }
}
