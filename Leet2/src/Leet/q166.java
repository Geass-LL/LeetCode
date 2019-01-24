package Leet;

import java.util.*;

//无非是用map记录循环出现的位置

public class q166 {
	public String fractionToDecimal(int numerator, int denominator) {
		String res=String.valueOf(numerator/denominator);
		if(numerator<0&&denominator<0) {
			numerator=-numerator;
			denominator=-denominator;
		}else if(numerator>0&&denominator<0) {
			denominator=-denominator;
			if(res.charAt(0)=='0') res="-"+res;
		}else if(numerator<0&&denominator>0) {
			numerator=-numerator;
			if(res.charAt(0)=='0') res="-"+res;
		}
		int rem=numerator%denominator;
		if(rem==0) {
			return res;
		}else {
			res+=".";
			String remres="";
			int i=0;
			Map<Integer,Integer> map=new HashMap<Integer,Integer>();
			while(!map.containsKey(rem)) {
				map.put(rem, i++);
				rem*=10;
				if(rem<denominator) {
					remres+="0";
				}else {
					remres+=String.valueOf(rem/denominator);
					rem%=denominator;
					if(rem==0) break;
				}
			}
			if(rem==0) return res+remres;
			else return res+remres.substring(0,map.get(rem))+"("+remres.substring(map.get(rem))+")";
		}
	}
}
