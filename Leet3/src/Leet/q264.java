package Leet;

/*
 * 注释的两种方法其实是一样的，只不过第一种方法可能涉及更多的比较，运行效率更低，但可读性强。
 * 从1，2，3，4，5作为引子，往后的值通过计算2乘上某个数，3乘上某个数，5乘上某个数的最小值得到；
 * 只要碰到最小值相等的情况，乘的这个数位置就应该后移。
 */

public class q264 {
	public int nthUglyNumber(int n) {
		if(n<=5) return n;
		int[] nums=new int[n+1];
		int i=0;
		while(i<=5) {
			nums[i]=i++;
		}
		/*
		int[] pos= {3,2,2};
		int[] p= {2,3,5};
		while(i<=n) {
			int[] value= {p[0]*nums[pos[0]],p[1]*nums[pos[1]],p[2]*nums[pos[2]]};
			int min=Math.min(value[0], Math.min(value[1], value[2]));
			nums[i++]=min;
			for(int j=0;j<3;j++) {
				if(value[j]==min) pos[j]++;
			}
		}
		*/
		/*
		int pos2=3,pos3=2,pos5=2;
		while(i<=n) {
			int num1=nums[pos2]*2,num2=nums[pos3]*3,num3=nums[pos5]*5;
			if(num1<num2&&num1<num3) {
				pos2++;
				nums[i++]=num1;
			}else if(num2<num1&&num2<num3) {
				pos3++;
				nums[i++]=num2;
			}else if(num3<num2&&num3<num1) {
				pos5++;
				nums[i++]=num3;
			}else if(num1==num2&&num1<num3) {
				pos2++;
				pos3++;
				nums[i++]=num1;
			}else if(num2==num3&&num2<num1) {
				pos3++;
				pos5++;
				nums[i++]=num2;
			}else if(num3==num1&&num3<num2) {
				pos2++;
				pos5++;
				nums[i++]=num3;
			}else if(num1==num2&&num1==num3) {
				pos2++;
				pos3++;
				pos5++;
				nums[i++]=num1;
			}
		}*/
		for(int j=0;j<=n;j++) {
			System.out.println(String.valueOf(nums[j])+' ');
		}
		return nums[n];
    }
}
