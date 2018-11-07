package Leet;

import java.util.*;

/*
 * ����������������q47�ķ���ȥ�ء�ע�⣬�������򣬷����������⡣
 */

public class q90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int[] cho=new int[nums.length];
		dyp(res,new ArrayList<Integer>(),nums,cho,0);
		return res;
    }
	void dyp(List<List<Integer>> res,List<Integer> temp,int[] nums,int[] cho,int deep) {
		res.add(new ArrayList(temp));
		for(int i=deep;i<nums.length;i++) {
			if(i>0&&nums[i]==nums[i-1]&&cho[i-1]==0) continue;
			//��仰����˼��
			//����붯�õڶ����ظ����֣���ô��һ���ظ����ֱ����Ѿ�ʹ�ù����������Ҫ������
			temp.add(nums[i]);
			cho[i]=1;
			dyp(res,temp,nums,cho,i+1);
			cho[i]=0;
			temp.remove(temp.size()-1);
		}
	}
}
