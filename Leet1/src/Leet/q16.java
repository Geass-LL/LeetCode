package Leet;

import java.util.Arrays;
/*
 * 类似3sum问题，只不过简化到2sum时，求的不是0而是差值。
 * differ记录全局差值，初始化为最大；differ=目标-实际，输出时：实际=目标-differ
 * 3sum简化到2sum，则differ既是3sum的差值也是2sum的差值；
 * 从两边往中间计算，利用2sum原则收缩，每次收缩记录differ，当differ绝对值减小时，记录differ。
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
