package Leet;

/*
 * 坚信自己的是对的，别人的是错的，反正不管，我就是对的。
 * Leetcode的答案是错的。
 * /...怎么可能化简得到/...的？
 */
import java.util.*;

public class q71 {
	public String simplifyPath(String path) {
		Stack<String> st=new Stack<String>();
		String temp="",res="";
		int length=path.length(),i=0;
		while(i<length) {
			if(path.charAt(i)=='/') {
				i++;
				if(temp.length()!=0)
					st.push(temp);
				temp="";
			}else if(path.charAt(i)=='.') {
				if(i<length-1&&path.charAt(i+1)=='.') {
					if(!st.isEmpty())
						st.pop();
					i+=2;
				}else {
					i++;
				}
			}else {
				temp+=path.charAt(i);
				i++;
			}
		}
		if(temp.length()!=0)
			st.push(temp);
		for(String eachcell:st) {
			res+="/";
			res+=eachcell;
		}
		if(res.length()==0)
			res="/";
		return res;
    }
}
