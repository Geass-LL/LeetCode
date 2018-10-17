package Leet;
/*
 * mad�����⣬Leetcode�ϲ����ۡ�
 * �����߸���ѽ�������ǰֵ����֮ǰ�ĺ�С�ڵ�ǰֵ���Ѻ��޸�Ϊ��ǰֵ������֮ǰ�ĺͼ��ϵ�ǰֵ��ÿ�ζ���¼�����͡�
 */
public class q53_side {
	public int maxSubArray(int[] nums) {
		int sum=nums[0];
		int maxsum=sum;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]+sum<nums[i])
				sum=nums[i];
			else
				sum+=nums[i];
			if(sum>maxsum)
				maxsum=sum;
		}
		return maxsum;
	}
}
