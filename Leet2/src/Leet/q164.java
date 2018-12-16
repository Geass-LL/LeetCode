package Leet;

import java.util.Arrays;

/*
 * 见Onenote。
 * 具体思路：利用桶排序的方法，同时结合抽屉原理，如果将n个数放入n+1个桶，那么肯定有至少有一个桶是空的，
 * 则最大gap必定是两个相邻的桶之间。
 */

public class q164 {
	public int maximumGap(int[] nums) {
		if(nums==null||nums.length<2) return 0;
		int maxnum=Integer.MIN_VALUE,minnum=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) {
			minnum=Math.min(minnum, nums[i]);
			maxnum=Math.max(maxnum, nums[i]);
		}
		if(nums.length==2) return maxnum-minnum;
		if(maxnum==minnum) return 0;
		int gap=(int)Math.ceil((double)(maxnum-minnum)/nums.length);//把n个数放入n+1个桶中，除以的大小为桶的个数减1.
		int[] gaps_minnum=new int[nums.length+1],gaps_maxnum=new int[nums.length+1],gaps=new int[nums.length+1];//分别用于记录当前桶的最小值，最大值及存放的数据个数；
		Arrays.fill(gaps_minnum,Integer.MAX_VALUE);//初始化最小值为最大数
		Arrays.fill(gaps_maxnum,Integer.MIN_VALUE);//初始化最大值为最小数
		for(int i=0;i<nums.length;i++) {
			int index=(nums[i]-minnum)/gap;//计算桶的序号
			gaps_minnum[index]=Math.min(gaps_minnum[index],nums[i]);//填充
			gaps_maxnum[index]=Math.max(gaps_maxnum[index],nums[i]);//填充
			gaps[index]++;
		}
		int res=0;
		int maxpre=gaps_maxnum[0];
		for (int i=1;i<gaps.length;i++) {
			if(gaps[i]==0) continue;//桶里面没数，跳过，且前桶的最大值并未被更新。
			res=Math.max(gaps_minnum[i]-maxpre, res);
			maxpre=gaps_maxnum[i];
		}
		return res;
    }
}
