package Leet;

import java.util.*;

public class q202 {
	public boolean isHappy(int n) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		while(!map.containsKey(n)) {
			map.put(n, 1);
			int res=0;
			while(n>=10) {
				res+=(n%10)*(n%10);
				n/=10;
			}
			res+=n*n;
			n=res;
			System.out.println(n);
			if(n==1)	return true;
		}
		return false;
    }
}
