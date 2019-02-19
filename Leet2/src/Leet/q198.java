package Leet;

/*
 * 根据是否偷第i家分两种情况：
 * 1、偷这一家，不偷上一家：res[i]=res[i-2]+nums[i];
 * 2、不偷这一家，等下一家：res[i]=res[i-1];
 * 取这两种情况的最大值
 */

public class q198 {
	public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int length=nums.length+1;
        int[] res=new int[length];
        res[0]=0;
        res[1]=nums[0];
        for(int i=2;i<length;i++){
            res[i]=Math.max(res[i-1],res[i-2]+nums[i-1]);
        }
        return res[length-1];
    }
}
