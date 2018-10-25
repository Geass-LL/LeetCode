package Leet;

public class q65 {
	public boolean isNumber(String s) {
		if(s==null||s.length()==0) return false;
		int i=0,length=s.length();
		//处理前后的空格
		if(s.charAt(0)==' ') {
			return isNumber(s.substring(1, length));
		}
		if(s.charAt(length-1)==' ') {
			return isNumber(s.substring(0,length-1));
		}
		int state=0,dnum=0;
		boolean over=false;
		while(i<length) {
			char cur=s.charAt(i);
			if(isvalid(cur)) {
				//state=0为处理最开始的字符
				if(state==0) {
					if(cur=='e')
						return false;
					else {
						state=1;//计数阶段
						if(cur=='.') dnum=1;//记录.的数目
                        else if(isnum(cur)) over=true;//可以结束（最后一位必须是数字）
					}
				}else if(state==1) {
					if(isnum(cur)&&dnum<=1) {//数字，且小数点个数小于等于1，OK
						over=true;
					}else if(cur=='e'&&over&&dnum<=1) {//碰到了e，over表示前面出现过数字，dnum表示小数点个数小于等于1
						over=false;//出现了e不能结束
						state=2;//转向e后段
					}else if(cur=='.'&&dnum<=1) {//记录小数点个数
						dnum+=1;
                        if(dnum>=2) return false;//大于两个出错
					}else {
						return false;
					}
				}else if(state==2) {
					if((cur=='-'||cur=='+')&&!over) {//前面没出现过数字，可以首先出现-或者+
					}else if(isnum(cur)) {//出现了数字
						over=true;//可以结束了
					}else {
						return false;
					}
				}
			}else {
				return false;
			}
			i++;
		}
		if(over)	
			return true;
		else 
			return false;
    }
	boolean isvalid(char indata) {
		char[] temp={'0','1','2','3','4','5','6','7','8','9','e','.','-','+'};
		for(char eachchar:temp) {
			if(eachchar==indata)
				return true;
		}
		return false;
	}
	boolean isnum(char indata) {
		char[] temp={'0','1','2','3','4','5','6','7','8','9'};
		for(char eachchar:temp) {
			if(eachchar==indata)
				return true;
		}
		return false;
	}
}
