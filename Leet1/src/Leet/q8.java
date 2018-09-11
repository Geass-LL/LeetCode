package Leet;

import java.util.HashMap;
import java.util.Map;

public class q8 {
    public int myAtoi(String str) {
        int res=0;
        boolean flag=false;
        int temp=1;
        for (int i=0;i<str.length();i++) {
        	char charnow=str.charAt(i);
        	if (flag==false) {
	        	if(charnow=='-') {
	        		temp=-1;
	        		flag=true;
	        	}else if(charnow=='+') {
	        		flag=true;
	        	}else if(Character.isDigit(charnow)) {
	        		res+=Integer.valueOf(charnow)-48;
	        		System.out.println(res);
	        		flag=true;
	        	}else if(charnow==' ') {
	        		continue;
	        	}else {
	        		return res;
	        	}
        	}else {
        		if (Character.isDigit(charnow)) {
        			int num=charnow-'0';
        			if (temp==1) {
        				if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10) {
            				return Integer.MAX_VALUE;
            			}
        				res=res*10+num;
        			}else {
        				if (res < Integer.MIN_VALUE/10 || res == Integer.MIN_VALUE / 10 && num > -(Integer.MIN_VALUE%10)) {
        					return Integer.MIN_VALUE;
        				}
        				res=res*10-num;
        			}
        		}else {
        			return res;
        		}
        	}
        }
        return res;
    }
}