package Leet;

public class q283 {
	public void moveZeroes(int[] nums) {
		/*�����õĽ�����˼·��ɵ�
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				int j=i+1;
				while(j<nums.length) {
					if(nums[j]!=0) {
						nums[i]=nums[j];
						nums[j]=0;
						break;
					}
					j++;
				}
				if(j>=nums.length)	break;
			}
		}*/
		//�����˼·��ֱ�ӾͲ�������Ҳ����˵��0����ǰ�棬ʣ�µ�ȫ��Ϊ��0����
		int i=0,i1=0;
		while(i<nums.length) {
			if(nums[i]!=0) {
				nums[i1]=nums[i];
				i1++;
			}
			i++;
			while(i<nums.length&&nums[i]==0) {
				i++;
			}
		}
		for(i=i1;i<nums.length;i++) {
			nums[i]=0;
		}
    }
}
