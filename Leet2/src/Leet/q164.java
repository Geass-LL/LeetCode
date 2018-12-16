package Leet;

import java.util.Arrays;

/*
 * ��Onenote��
 * ����˼·������Ͱ����ķ�����ͬʱ��ϳ���ԭ�������n��������n+1��Ͱ����ô�϶���������һ��Ͱ�ǿյģ�
 * �����gap�ض����������ڵ�Ͱ֮�䡣
 */

public class q164 {
	public int maximumGap(int[] nums) {
		if(nums==null||nums.length<2) return 0;
		int maxnum=Integer.MIN_VALUE,minnum=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) {
			minnum=Math.min(minnum, nums[i]);
			maxnum=Math.max(maxnum, nums[i]);
		}
		if(nums.length==2) return maxnum-minnum;
		if(maxnum==minnum) return 0;
		int gap=(int)Math.ceil((double)(maxnum-minnum)/nums.length);//��n��������n+1��Ͱ�У����ԵĴ�СΪͰ�ĸ�����1.
		int[] gaps_minnum=new int[nums.length+1],gaps_maxnum=new int[nums.length+1],gaps=new int[nums.length+1];//�ֱ����ڼ�¼��ǰͰ����Сֵ�����ֵ����ŵ����ݸ�����
		Arrays.fill(gaps_minnum,Integer.MAX_VALUE);//��ʼ����СֵΪ�����
		Arrays.fill(gaps_maxnum,Integer.MIN_VALUE);//��ʼ�����ֵΪ��С��
		for(int i=0;i<nums.length;i++) {
			int index=(nums[i]-minnum)/gap;//����Ͱ�����
			gaps_minnum[index]=Math.min(gaps_minnum[index],nums[i]);//���
			gaps_maxnum[index]=Math.max(gaps_maxnum[index],nums[i]);//���
			gaps[index]++;
		}
		int res=0;
		int maxpre=gaps_maxnum[0];
		for (int i=1;i<gaps.length;i++) {
			if(gaps[i]==0) continue;//Ͱ����û������������ǰͰ�����ֵ��δ�����¡�
			res=Math.max(gaps_minnum[i]-maxpre, res);
			maxpre=gaps_maxnum[i];
		}
		return res;
    }
}
