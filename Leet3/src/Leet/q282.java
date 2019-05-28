package Leet;



import java.util.*;

/*
 * 参考博客：https://www.cnblogs.com/grandyang/p/4814506.html
 * 如果把一个式子看成A+B+C+D的形式，其中的ABCD可以是负数，也可以是数字的连乘积；
 * 那么这里的diff就是表示每一步的ABCD；
 * 比如当前我们有了A+B,新值为c
 * 对于加法，diff直接赋新值即可，A+B+c
 * 若是减法，diff为新值的负数，A+B+(-c)
 * 若是乘法，新的diff应该为前一个diff与当前新值的税乘积，A+(B*c)
 * curnum则表示计算到当前为止的取值，加减法很容易理解；
 * 对于乘法，上一个curnum=A+B,其中的B为上一个diff,那么新的curnum应该为new_curnum=A+B*c=curnum-diff+diff*c
 */
public class q282 {
	public List<String> addOperators(String num, int target) {
		List<String> res=new ArrayList<String>();
		helper(num,target,0,0,"",res);
		return res;
    }
	void helper(String num,int target,long diff,long curnum,String tempres,List<String> res) {
		if(num.length()==0&&curnum==target) {
			res.add(tempres);
			return;
		}
		for(int i=1;i<=num.length();i++) {
			String cur=num.substring(0, i);
			if(cur.length()>1&&cur.charAt(0)=='0')	return;//排除0引发的问题
			String next=num.substring(i);
			if(tempres.length()>0) {
				helper(next,target,Long.valueOf(cur),curnum+Long.valueOf(cur),tempres+"+"+cur,res);
				helper(next,target,-Long.valueOf(cur),curnum-Long.valueOf(cur),tempres+"-"+cur,res);
				helper(next,target,diff*Long.valueOf(cur),(curnum-diff)+diff*Long.valueOf(cur),tempres+"*"+cur,res);
			}else {
				helper(next,target,Long.valueOf(cur),Long.valueOf(cur),cur,res);//单独写是因为式子最开始没有符号，是单纯的数字
			}
		}
	}
}
