package Leet;

import java.util.*;

/*
 * �������Ҫ��46����һ���޸ģ���������޸��Ҳ�û���뵽��
 * ���ȶ�����������򣬱�Ҫ�ġ�
 * Ȼ����ÿ�μ���ʱ�����ǰһ��Ԫ���뵱ǰ��Ԫ����ͬ�����Ѿ������ʹ��ˣ����������Ԫ�ء�
 */

public class q47 {
	public List<List<Integer>> permute(int[] nums) {
        int[] cho=new int[nums.length];
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int deep=0;
        Arrays.sort(nums);
        btk(new ArrayList<Integer>(),deep,res,nums,nums.length,cho);
        return res;
    }
	void btk(List<Integer> tempres, int deep,List<List<Integer>> res,int[] nums,int length,int[] cho) {
		if(deep==length) {
			res.add(new ArrayList(tempres));
		}else {
			deep++;
			for(int i=0;i<cho.length;i++) {
				if(i>0&&nums[i-1]==nums[i]&&cho[i-1]==0) continue;//��仰���ǲ���ѽ����������
				if(cho[i]==0) {
					tempres.add(nums[i]);
					cho[i]=1;
					btk(tempres,deep,res,nums,length,cho);
					cho[i]=0;
					tempres.remove(tempres.size()-1);
				}
			}
		}
	}
}
