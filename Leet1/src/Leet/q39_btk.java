package Leet;

import java.util.*;

public class q39_btk {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	List<Integer> tempres=new ArrayList<Integer>();
    	btk(res,0,tempres,candidates,target);
    	return res;
    }
	void btk(List<List<Integer>> res,int deep,List<Integer> tempres,int[] candidates,int target) {
		if(target<0)
			return;
		if(target==0) {
			res.add(new ArrayList(tempres));//��Ҫ����Ȼ���Ǻܶ��������res.add(tempres)���޷���������͵�res�С�
			return;
		}else {
			for(int i=deep;i<candidates.length;i++) {
				int tempvalue=candidates[i];
				tempres.add(tempvalue);
				btk(res,i,tempres,candidates,target-tempvalue);
				/*��������ע��ȥ�����ǿ�����Ϊһ����ֹ��������ֻ�㵽5�������ֹͣ��
				if(res.size()>4)
					return;
					*/
				tempres.remove(tempres.size()-1);				
			}
		}
	}
}
