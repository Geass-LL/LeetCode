package Leet;
/*
 * ̰���㷨����ʵ��û�к��ѡ�
 * �ԣ����Ǵӵ�ǰλ�õ���������λ�ã���һ������Ѱ���ܻ����������λ�ø�Զ�����Σ�������¼����ѡ����Զ�ģ���Ϊ̰���㷨��
 * ע�⣺�����棬�������ĳ���Ϊ1����������Ҫ���ɻ�Ҫ����һ�Ρ�
 */
public class q45 {
	public int jump(int[] nums) {
        int res=0,cur=0,maxindex=cur,maxjump=nums[cur];
        if(nums==null||nums.length<=1) {
        	return 0;
        }
        while(cur+maxjump<nums.length-1) {
        	maxindex=cur;
        	maxjump=nums[cur];
        	for(int i=cur+1;i<=cur+nums[cur];i++) {
        		if(nums[i]+i>maxindex+maxjump) {
        			maxindex=i;
        			maxjump=nums[i];
        		}
        	}
        	cur=maxindex;
        	res++;
        }
        return res+1;
    }
}
