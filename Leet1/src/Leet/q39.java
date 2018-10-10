package Leet;

import java.util.*;
/*
 * 用动态规划做的。问题可以分解成两个子问题求解：
 * 1、使用第一个数，求使用1-N次第一个数的和firstsum，求解剩余数据的和为target-firstsum的问题；
 * 2、不使用第一个数，求解剩余数据和为target的问题。
 * 需要注意：list的addAll方法不能用null作为参数；
 */
public class q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> res=dyp(candidates,0,candidates.length,target);
    	return res;
    }
    List<List<Integer>> dyp(int[] candidates,int from,int to,int target){
    	//终止条件
    	if(from>=to) {
    		return null;
    	}
    	List<Integer> samenum=new ArrayList<Integer>();//第一个数重复出现
    	List<List<Integer>> res=new ArrayList<List<Integer>>();//最终结果
    	int firstsum=candidates[from],curnum=candidates[from];//第一个数的累加及第一个自身
    	from++;//下一个问题
    	while(firstsum<target) {//第一个N次和一定要小于目标值
    		samenum.add(curnum);//第一个数的解部分
    		List<List<Integer>> tempres1=dyp(candidates,from,candidates.length,target-firstsum);//其他解部分
    		if(tempres1!=null) {//非空
	    		for(List<Integer> eachlist:tempres1) {
	    			eachlist.addAll(samenum);//把第一个数的值和其他解部分合并
	    			res.add(eachlist);//作为最终结果的一个可行解
	    		}
    		}
    		firstsum+=curnum;//第一个数N->N+1次
    	}
    	if(firstsum==target){//重要！！！！！！！！！！！！！！！！重要
    		samenum.add(curnum);//from=0的时候忘记把第一个数加进去了
    		res.add(samenum);//仅第一个数引发的可行解
    	}
    	List<List<Integer>> tempres2=dyp(candidates,from,candidates.length,target);//第二个子问题
    	if(tempres2!=null)//非空
    		res.addAll(tempres2);
    	return res;
    }
}