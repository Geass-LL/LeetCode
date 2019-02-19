package Leet;

/*
 * �����Ƿ�͵��i�ҷ����������
 * 1��͵��һ�ң���͵��һ�ң�res[i]=res[i-2]+nums[i];
 * 2����͵��һ�ң�����һ�ң�res[i]=res[i-1];
 * ȡ��������������ֵ
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
