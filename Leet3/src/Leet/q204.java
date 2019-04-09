package Leet;

import java.util.*;

/*
 * ��Ҫע�����㣺
 * ����һ�������������ʱ��������ƽ����ʼ������Ҫע��Խ�����⣻
 * ��Ҫ�ù�ϣ��ṹ�ᳬʱ����boolean�����ok��
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
