package Leet;

/*
 * ȷʵ�Ǽ����⣬��index��¼���ظ�Сֵλ�ã�ÿ��������һ��̨�ף���indexλ�õ�ֵ��Ϊ��ǰ��̨�׼���
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
