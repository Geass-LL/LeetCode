package Leet;

/*
 * 以 1 2 3 4 2 6为例，求一遍就知道了。
 * 值 1 2 3 4 1 5
 */
public class q300 {
	public int lengthOfLIS(int[] nums) {
		int n=nums.length;
		int[] d=new int[n];
        if(n==0) return 0;
        d[0]=1;
        int res=1;
		//d[i]表示以第i位结尾的最大长度
		for(int i=1;i<n;i++) {
			d[i]=1;
			for(int j=i-1;j>=0;j--) {
				if(nums[i]>nums[j]&&d[j]+1>d[i]) {
					d[i]=d[j]+1;
				}
			}
			res=d[i]>res?d[i]:res;
		}
		return res;
    }
}
