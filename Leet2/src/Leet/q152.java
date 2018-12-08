package Leet;

/*
 * �ο����͵�д�����μ���ַ��
 * https://www.cnblogs.com/bakari/p/4007368.html
 * ����ά��һ��ȫ�ֱ�����һ���ֲ�����
 */

public class q152 {
	public int maxProduct(int[] nums) {
		int length=nums.length;
		if(length==0) return 0;
		int max_local=nums[0],min_local=nums[0],global=nums[0];
		for(int i=1;i<length;i++) {
			int max_copy=max_local;
			max_local=Math.max(Math.max(max_local*nums[i], min_local*nums[i]), nums[i]);
			min_local=Math.min(Math.min(min_local*nums[i], max_copy*nums[i]), nums[i]);
			global=Math.max(global,max_local);
		}
		return global;
    }
}
