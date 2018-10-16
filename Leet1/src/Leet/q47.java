package Leet;

import java.util.*;

/*
 * 这个题需要对46题做一个修改，但是这个修改我并没有想到。
 * 即先对数组进行排序，必要的。
 * 然后在每次加深时，如果前一个元素与当前的元素相同，且已经被访问过了，则跳过这个元素。
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
				if(i>0&&nums[i-1]==nums[i]&&cho[i-1]==0) continue;//这句话还是不懂呀！！！！！
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
