package Leet;

/*
 * 搞不懂这个为什么是Hard?
 * 解题见onenote
 */

public class q42 {
	public int trap(int[] height) {
		int left=0,right=height.length-1,level=0;
		int leftlevel,rightlevel;
		int res=0;
		while(left<right) {
			leftlevel=height[left];
			rightlevel=height[right];
			if(leftlevel>level&&rightlevel>level) {
				int prelevel=level;
				level=Math.min(leftlevel, rightlevel);
				res+=cacu(height,left,right,level,prelevel);
			}
			if(leftlevel<rightlevel)
				left++;
			else
				right--;
		}
		return res;
    }
	int cacu(int[] height,int left,int right,int level,int prevel) {
		int res=0;
		for(int i=left;i<right;i++) {
				res+=Math.min(level-prevel, Math.max(0, level-height[i]));
		}
		return res;
	}
}
