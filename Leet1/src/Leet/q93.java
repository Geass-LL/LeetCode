package Leet;

import java.util.*;

/*
 * 经典的回溯法，现在已经可以灵活地运用回溯法的形式了。
 */

public class q93 {
	public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<String>();
        btk(res,"",s,0);
        return res;
    }
	void btk(List<String> res,String temp,String s,int deep) {
		if(deep==3) {
			if(valid(s)){
				res.add(new String(temp+s));
			}else {
				return;
			}
		}else {
			deep++;
			int i=1;
			while(s.length()>=i&&valid(s.substring(0, i))) {//直接在while循环中寻找可行解
				temp=temp+s.substring(0,i)+'.';
				btk(res,temp,s.substring(i),deep);
				temp=temp.substring(0,temp.length()-i-1);
				i++;
			}
		}
	}
	boolean valid(String s) {
		if(s.length()>0&&s.length()<4) { //注意如果长度过长可能会引起转为int的错误
			int temp=Integer.valueOf(s);
			if(String.valueOf(temp).length()==s.length()&&temp<256) //根据长度相等去掉00，01类似这样的情况。
				return true;
		}
		return false;
	}
}
