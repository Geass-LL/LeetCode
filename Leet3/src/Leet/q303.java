package Leet;

public class q303 {
	public int[] nums;
	/* 
	public q303(int[] nums) {
		this.nums=nums;
	}
	public int sumRange(int i,int j) {
		int sum=0;
		for(int ii=i;ii<=j;ii++) {
			System.out.println(this.nums[ii]);
			sum+=this.nums[ii];
		}
		return sum;
	}*/
	//上面的方法只是单纯地将数据存储下来了，如果执行多次求取sunRange的操作时，必然会出现耗时过长；
	//下面的方法提前将数据的和求了出来，可能会出现溢出，这里没做处理，如果执行多次求取sumRange的操作时，不会出现耗时过长的问题。
	public q303(int[] nums) {
		int length=nums.length;
		this.nums=new int[length+1];
		if(length>0)	this.nums[0]=0;
		for(int i=1;i<=length;i++) {
			this.nums[i]+=this.nums[i-1]+nums[i-1];
		}
	}
	public int sumRange(int i,int j) {
		int sum=0;
		return this.nums[j+1]-this.nums[i];
	}
}
