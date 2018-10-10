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
			res.add(new ArrayList(tempres));//重要，虽然不是很懂，如果是res.add(tempres)就无法将结果推送到res中。
			return;
		}else {
			for(int i=deep;i<candidates.length;i++) {
				int tempvalue=candidates[i];
				tempres.add(tempvalue);
				btk(res,i,tempres,candidates,target-tempvalue);
				/*如果把这段注释去掉，那可以做为一个终止条件，即只算到5个结果就停止。
				if(res.size()>4)
					return;
					*/
				tempres.remove(tempres.size()-1);				
			}
		}
	}
}
