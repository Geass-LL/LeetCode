package Leet;

import java.util.HashMap;
import java.util.Map;
/*
 * 思路：以Map的形式存储；
 * 考虑到类似IX这样的前置小数最多1位，一直让sum记录上一位的num；
 * 当出现num>sum时，即XIV情况出现，res在之前已经加了上一们的num即当前的sum的情况下，减去两个sum再加上当前的num；这之后更新sum
 * 当为num<sum时，即XI这种情况，直接加上当前的num即可，更新res，
 * 效果不错，98.77%
 */
public class q13 {
	public int romanToInt(String s) {
        Map map=new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int num=0;
        int res=0;
        int sum=0;
        for (int i=0;i<s.length();i++) {
        	num=(int)map.get(s.charAt(i));
        	if (num>sum) {
        		res=res+num-2*sum;
        		sum=num;
        	}else {
        		sum=num;
    			res+=num;
        	}
        }
        return res;
    }
}
