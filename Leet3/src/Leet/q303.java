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
	//����ķ���ֻ�ǵ����ؽ����ݴ洢�����ˣ����ִ�ж����ȡsunRange�Ĳ���ʱ����Ȼ����ֺ�ʱ������
	//����ķ�����ǰ�����ݵĺ����˳��������ܻ�������������û���������ִ�ж����ȡsumRange�Ĳ���ʱ��������ֺ�ʱ���������⡣
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
