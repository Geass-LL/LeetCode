package Leet;

/*
 * ���������������һ����ɽ�£���ʵ���Ǽ�¼ɽ����ɽ�ȵĸ���+1��
 * ���¾�Ҫ�ϵ��������¾�Ҫ�µ��ס�
 * state=0��ʾƽ�أ�state=1��ʾ�������£�state=2��ʾ�������¡�
 */

public class q376 {
	public int wiggleMaxLength(int[] nums) {
		if(nums==null||nums.length<=1)	return nums.length;
		int state=0,res=2;
		if(nums[1]<nums[0]) state=1;
		else if(nums[1]>nums[0]) state=2;
		else res=1;
		for(int i=2;i<nums.length;i++) {
			if(state==1&&nums[i]>nums[i-1]) {//�������£��������£��޸�״̬Ϊ����
				state=2;
				res++;
			}
			if(state==2&&nums[i]<nums[i-1]) {//�������£��������£��޸�״̬Ϊ����
				state=1;
				res++;
			}
			if(state==0) {//���ʼ��ƽ��ʱ��Ҫ���ҵ������£�state!=0�Ժ��ٹ�ƽ�ص������Ҳ�������ƽ�ص������
				if(nums[i]>nums[i-1]) {
					state=2;
					res++;
				}else if(nums[i]<nums[i-1]) {
					state=1;
					res++;
				}
			}
		}
		return res;
    }
}
