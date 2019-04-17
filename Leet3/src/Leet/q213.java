package Leet;

/*
 * ˼·��
 * �����������res0��ʾǿ�Ʋ�͵��һ�ң�res1��ʾǿ��͵��һ�ң�
 * res[i]��ʾ�ڱض�͵��i��ʱ���ֵ�����ַ����������
 * 1����i-1��͵�ˣ����ڲ�͵��i-1�ң���͵��i�ң�
 * 2����i-1��û͵������ֱ��͵��i�ң�
 * ���Ľ��Ӧ�����������ֽ��֮���ֵ��ԭ���ǲ����ܷ��Ų�͵ѽ��
 */

public class q213 {
	public int rob(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		if(nums.length==2) return Math.max(nums[0], nums[1]);
		if(nums.length==3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
		int[] res0=new int[nums.length],res1=new int[nums.length];
		res0[0]=0;
		res0[1]=nums[1];
		for(int i=2;i<nums.length;i++) {
			res0[i]=Math.max(nums[i]+res0[i-2], res0[i-1]-nums[i-1]+nums[i]);
		}
		res1[0]=nums[0];
		res1[1]=nums[1];
		for(int i=2;i<nums.length-1;i++) {
			res1[i]=Math.max(nums[i]+res1[i-2], res1[i-1]-nums[i-1]+nums[i]);
		}
		return Math.max(Math.max(res0[nums.length-1], res0[nums.length-2]), 
						Math.max(res1[nums.length-2], res1[nums.length-3]));
    }
}
