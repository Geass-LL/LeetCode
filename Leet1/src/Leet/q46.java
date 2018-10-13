package Leet;

import java.util.*;

/*
 * 一次成功的回溯法，100%。
 * 用cho来寻找可行解，用过的值为1，没用过的为0；
 * 还是原来的架构。真好用！！！！！
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
