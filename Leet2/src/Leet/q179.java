package Leet;

/*
 * 排序算法，这里采用的是冒泡排序，但是需要重新定义大小比较；
 *  1、给出的compare函数比较a和b的大小，如果a<b，返回true。
 */

public class q179 {
	public String largestNumber(int[] nums) {
        for(int i=0;i<nums.length;i++) {
        	for(int j=0;j<nums.length;j++) {
        		if(!compare(nums[i],nums[j])) {
        			int temp=nums[i];
        			nums[i]=nums[j];
        			nums[j]=temp;
        		}
        	}
        }
        String res="";
        for(int i=0;i<nums.length;i++) {
        	res+=String.valueOf(nums[i]);
        }
        if(res.substring(0, 1).equals("0")) res="0";//如果开头是零，说明后面的都是零，这种情况下，只保留一个零即可；
        return	res;
    }
	public boolean compare(int a,int b) {
		if(a==b) return false;
		boolean change=false;
		if(a>b) {
			int temp=a;
			a=b;
			b=temp;
			change=true;
		}
		boolean res=true;
		char[] chara=String.valueOf(a).toCharArray();
		char[] charb=String.valueOf(b).toCharArray();
		int i=0;
		while(i<chara.length) {
			//转换成char来从左到右比较每一位；
			if(chara[i]>charb[i]) {
				res=false;
				break;
			}else if(chara[i]<charb[i]) {
				res=true;
				break;
			}else {
				i++;
			}
		}
		if(i==chara.length) {
			//如果前面的几位都一致，执行这个操作，具体举个例子即可
			//a=343,b=3433,tempb=3343.
			//ab=343|3433|
			//ba=343|3343|
			//因此实际比较的是3343和3433的大小。
			//有个例外的情况是如果a和tempb相等，如
			//a=3,b=30,tempb=3
			//应该得出的结果是a<b，不把b和tempb做比较。
			int tempb=Integer.valueOf(String.valueOf(b).substring(i)+String.valueOf(b).substring(0, i));
			if(a==tempb) {
				res=false;
			}else {
				if(b<tempb) res=true;
				else res=false;
			}
		}
		if(change) return !res;
		else return res;
	}
}
