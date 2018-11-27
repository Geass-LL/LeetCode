package Leet;

/*
 * 时间倒是超过100%，但是代码不够简练，采用的是贪心算法：
 * 1、用gas-cost表示剩余量；
 * 2、从start开始，如果剩余量小于0，直接跳过；
 * 从大于0的剩余量开始加和，直到和小于0重新记录start。需要找到满足完成循环的start。
 * 完成循环，返回start；
 * start找到最后也没有找到可以完成循环的，返回-1.
 */

public class q134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas.length==0||gas==null) return 0;
		int start=0,length=gas.length;
		int[] remain=new int[length];
		for(int i=0;i<length;i++) {
			remain[i]=gas[i]-cost[i];//用gas-cost表示剩余量；
		}
		while(start<length) {
			if(remain[start]>=0) {
				int cursum=0,i=start;
				while(i<length) {
					cursum+=remain[i];
					if(cursum<0) {//从大于0的剩余量开始加和，直到和小于0重新记录start。
						start=i+1;
						break;
					}else {
						i++;
					}
				}
				if(i>=length) {//需要找到满足完成循环的start。
					while(i-length<start) {
						cursum+=remain[i-length];
						if(cursum<0) {
							return -1;
						}else {
							i++;
						}
					}
					return start;//需要找到满足完成循环的start。
				}
			}else {
				start++;//如果剩余量小于0，直接跳过；
			}
		}
		return -1;//start找到最后也没有找到可以完成循环的，返回-1.
    }
}
