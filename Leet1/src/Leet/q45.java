package Leet;
/*
 * 贪心算法，其实并没有很难。
 * 对，就是从当前位置到能跳到的位置，这一段中搜寻可能会比能跳到的位置更远的情形，并做记录从中选择最远的，即为贪心算法。
 * 注意：这里面，如果数组的长度为1，则不跳，不要理解成还要再跳一次。
 */
public class q45 {
	public int jump(int[] nums) {
        int res=0,cur=0,maxindex=cur,maxjump=nums[cur];
        if(nums==null||nums.length<=1) {
        	return 0;
        }
        while(cur+maxjump<nums.length-1) {
        	maxindex=cur;
        	maxjump=nums[cur];
        	for(int i=cur+1;i<=cur+nums[cur];i++) {
        		if(nums[i]+i>maxindex+maxjump) {
        			maxindex=i;
        			maxjump=nums[i];
        		}
        	}
        	cur=maxindex;
        	res++;
        }
        return res+1;
    }
}
