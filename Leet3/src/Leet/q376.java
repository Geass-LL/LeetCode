package Leet;

/*
 * 把整个过程想像成一连串山坡，其实就是记录山顶上山谷的个数+1。
 * 上坡就要上到顶，下坡就要下到底。
 * state=0表示平地，state=1表示正在下坡，state=2表示正在上坡。
 */

public class q376 {
	public int wiggleMaxLength(int[] nums) {
		if(nums==null||nums.length<=1)	return nums.length;
		int state=0,res=2;
		if(nums[1]<nums[0]) state=1;
		else if(nums[1]>nums[0]) state=2;
		else res=1;
		for(int i=2;i<nums.length;i++) {
			if(state==1&&nums[i]>nums[i-1]) {//正在下坡，遇到上坡，修改状态为上坡
				state=2;
				res++;
			}
			if(state==2&&nums[i]<nums[i-1]) {//正在上坡，遇到下坡，修改状态为下坡
				state=1;
				res++;
			}
			if(state==0) {//走最开始的平地时，要先找到上下坡，state!=0以后不再管平地的情况，也不会出现平地的情况。
				if(nums[i]>nums[i-1]) {
					state=2;
					res++;
				}else if(nums[i]<nums[i-1]) {
					state=1;
					res++;
				}
			}
		}
		return res;
    }
}
