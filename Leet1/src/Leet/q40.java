package Leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 比起39应该是简化了感觉，不必再维持firstsum了。
 * 首先得排个序！
 * 分成两个问题：
 * a,a,b,c,d,...
 * 1、有a的时候，把a包含进去计算后面为target-a的所有可能解；
 * 2、没有a的时候，跳过相同的a直接到b，计算b,c,d,...值为target的所有可能解。
 */
public class q40 {
	public List<List<Integer>> combination2Sum(int[] candidates, int target) {
		Arrays.sort(candidates);
    	List<List<Integer>> res=dyp(candidates,0,candidates.length,target);
    	return res;
    }
    List<List<Integer>> dyp(int[] candidates,int from,int to,int target){
    	//终止条件
    	if(from>=to) {
    		return null;
    	}
    	List<List<Integer>> res=new ArrayList<List<Integer>>();//最终结果
    	int curnum=candidates[from];
    	int nextfrom=from;//不包含第一个数，转换成从哪里开始的小问题。
    	while(nextfrom<to&&candidates[nextfrom]==curnum) {
    		nextfrom++;
    	}
    	from++;//下一个问题
    	if(curnum<target) {
    		List<List<Integer>> tempres1=dyp(candidates,from,candidates.length,target-curnum);
    		if(tempres1!=null) {//非空
	    		for(List<Integer> eachlist:tempres1) {
	    			eachlist.add(curnum);//把第一个数的值和其他解部分合并
	    			res.add(eachlist);//作为最终结果的一个可行解
	    		}
    		}
    	}else if(curnum==target){//重要！！！！！！！！！！！！！！！！重要
    		List<Integer> curres=new ArrayList();
    		curres.add(curnum);
    		res.add(curres);//仅第一个数引发的可行解
    	}
    	List<List<Integer>> tempres2=dyp(candidates,nextfrom,candidates.length,target);//第二个子问题
    	if(tempres2!=null)//非空
    		res.addAll(tempres2);
    	return res;
    }
}
