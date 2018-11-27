package Leet;

/*
 * 感觉，并不算什么Hard问题。。。
 * 解法：就是按照程序中写的规则
 * 1、rev表示到当前点的小于的数量，如3,2,1为2.
 * 2、如果大于，则当前分配糖果的值+1，rev清零，总数+当前分配值；
 * 3、如果等于，则当前分配糖果的值为1，rev清零，总数+1；
 * 4、如果小于，有点麻烦，牵涉到修改已经分配好的糖果值，
 * 		如果rev比最开始出现小于情况的分配糖果值小的话，直接修改出现时刻后面的值即可，也即总数+rev;
 * 		不然，出现时刻的值也需要做修改，即总数+rev+1.
 */

public class q135 {
	public int candy(int[] ratings) {
		int length=ratings.length,cur=1,rev=0,res=0,revcur=0;
		if(ratings==null||length==0) return 0;
		res=1;
		for(int i=1;i<length;i++) {//如果小于，有点麻烦，牵涉到修改已经分配好的糖果值，
			if(ratings[i]<ratings[i-1]) {
				if(rev==0) {
					revcur=cur;//最开始出现小于情况的分配糖果值
				}
				rev+=1;//rev表示到当前点的小于的数量，
				cur=1;
				res+=rev<revcur?(rev):(rev+cur);//如果rev比最开始出现小于情况的分配糖果值小的话，直接修改出现时刻后面的值即可，也即总数+rev;不然，出现时刻的值也需要做修改，即总数+rev+1.
			}else if(ratings[i]==ratings[i-1]) {//如果等于，则当前分配糖果的值为1，rev清零，总数+1；
				cur=1;
				rev=0;
				res+=rev+cur;
			}else {//如果大于，则当前分配糖果的值+1，rev清零，总数+当前分配值；
				cur++;
				rev=0;
				res+=rev+cur;
			}
		}
		return res;
    }
}
