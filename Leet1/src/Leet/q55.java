package Leet;

/*
 * �о����Ե���һ��Easy��������¼ÿ��λ���ܹ��������Զλ�ã����0��λ�ô��ڻ��ߵ�����Զλ���򷵻�false��
 * ע�������Զλ�õ����յ㣬�յ���0��Ҫ���ص���true��
 */
public class q55 {
	public boolean canJump(int[] nums) {
		int maxpos=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) {
				maxpos=Math.max(maxpos, nums[i]+i);
			}else {
				if(maxpos<=i&&i!=nums.length-1)
					return false;
			}
		}
		return true;
    }
}
