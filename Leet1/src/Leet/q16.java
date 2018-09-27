package Leet;

import java.util.Arrays;
/*
 * ����3sum���⣬ֻ�����򻯵�2sumʱ����Ĳ���0���ǲ�ֵ��
 * differ��¼ȫ�ֲ�ֵ����ʼ��Ϊ���differ=Ŀ��-ʵ�ʣ����ʱ��ʵ��=Ŀ��-differ
 * 3sum�򻯵�2sum����differ����3sum�Ĳ�ֵҲ��2sum�Ĳ�ֵ��
 * ���������м���㣬����2sumԭ��������ÿ��������¼differ����differ����ֵ��Сʱ����¼differ��
 */
public class q16 {
	public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<3) {
        	return 0;
        }
        Arrays.sort(nums);
        int differ=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++) {
        	if(i>0&&nums[i]==nums[i-1]) {
        		continue;
        	}
        	int sum = target-nums[i];
            int left = i + 1, right = nums.length - 1;
            int tempres=0;
            while (left < right) {
            	tempres=nums[left] + nums[right];
                if (tempres == sum) {
                	return target;  
                } else if (tempres < sum) {
                	if(sum-tempres<Math.abs(differ)) {
                		differ=sum-tempres;
                	}
                    while (left < right && nums[left] == nums[++left]) {}
                    
                } else {
                	if(tempres-sum<Math.abs(differ)) {
                		differ=sum-tempres;
                	}
                    while (left < right && nums[right] == nums[--right]) {}
                }
            }
        }
        return target-differ;
    }
}
