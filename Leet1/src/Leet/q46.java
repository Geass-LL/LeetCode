package Leet;

import java.util.*;

/*
 * һ�γɹ��Ļ��ݷ���100%��
 * ��cho��Ѱ�ҿ��н⣬�ù���ֵΪ1��û�ù���Ϊ0��
 * ����ԭ���ļܹ�������ã���������
 */
public class q46 {
	public List<List<Integer>> permute(int[] nums) {
        int[] cho=new int[nums.length];
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int deep=0;
        btk(new ArrayList<Integer>(),deep,res,nums,nums.length,cho);
        return res;
    }
	void btk(List<Integer> tempres, int deep,List<List<Integer>> res,int[] nums,int length,int[] cho) {
		if(deep==length) {
			res.add(new ArrayList(tempres));
		}else {
			deep++;
			for(int i=0;i<cho.length;i++) {
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
