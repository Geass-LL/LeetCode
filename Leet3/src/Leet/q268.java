package Leet;

/*
 * 用-1标记对应位置的数存在。最后一个个查过去，如果不是-1，那么输出这个数；全为-1，说明没有最后一个数。
 */

public class q268 {
	public int missingNumber(int[] nums) {
		int n=nums.length;
		for(int i=0;i<n;i++) {
			if(nums[i]==i) {
				nums[i]=-1;
				continue;
			}
			int j=nums[i];
			while(j>=0&&j<n&&nums[j]!=-1) {
				int temp=nums[j];
				nums[j]=-1;
				j=temp;
			}
		}
		for(int i=0;i<n;i++) {
			if(nums[i]!=-1)	return i;
		}
		return n;
    }
}
