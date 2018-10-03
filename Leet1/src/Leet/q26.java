package Leet;

/*
 * 确实是简单问题，用index记录非重复小值位置，每当数据上一个台阶，将index位置的值改为当前的台阶即可
 */
public class q26 {
    public int removeDuplicates(int[] nums) {
        int index=0;
        int curnum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]>curnum) {
        		nums[index]=nums[i];
        		curnum=nums[i];
        		index++;
        	}
        }
        return index;
    }
}
