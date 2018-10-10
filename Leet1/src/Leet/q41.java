package Leet;

/*
 * ������Hard��������⣻�������ջ�
 * 1��˵����constant extra space������������ԭ�������space������뷨û���ֹ���
 * 2��Ͱ�����У�����Ͱ��ʱ��Ҫʹ��while��ֱ������ǰλ�õ�ֵ��Ϊ��Чֵ��������Χ��ֵ��
 * 	  ����������ֵ��ͰӦ��ŵ���a[i]=i+1��Ϊֹ
 * ע�⣺�������nums[i]!=nums[nums[i]-1]����������������Ͱ���Ѿ������ˣ����������ͬʱ���֣�
 * 		էһ���������ȥ��������ȥ����������ͬ������ѭ����
 * http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
 * �ο���ַ
 */
public class q41 {
	public int firstMissingPositive(int[] nums) {
		int i=0;
		while(i<nums.length) {
			if(nums[i]<=nums.length&&nums[i]>0&&nums[i]!=i+1&&nums[i]!=nums[nums[i]-1]) {
				int temp=nums[nums[i]-1];
				nums[nums[i]-1]=nums[i];
				nums[i]=temp;
			}else {
				i++;
			}
		}
		for(i=0;i<nums.length;i++) {
			if(nums[i]!=i+1)
				return i+1;
		}
		return nums.length+1;
    }
}
