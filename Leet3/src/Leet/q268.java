package Leet;

/*
 * ��-1��Ƕ�Ӧλ�õ������ڡ����һ�������ȥ���������-1����ô����������ȫΪ-1��˵��û�����һ������
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
