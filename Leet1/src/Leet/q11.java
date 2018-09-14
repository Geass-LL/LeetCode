package Leet;
/*
 * 此题暴力可以通过测试，但是成绩5%左右，耗时很长；
 * 将两侧短的更新，每次更新时计算容积：
 * 从外面向里面包，如果容积高由最外侧的短边决定；
 * 如果height[left]>height[right],那么不必去管right左侧的所有。
 * 假设：该算法并没有遍历到容量最大的情况
我们令容量最大时的指针为p_left和p_right。根据题设，我们可以假设遍历时左指针先到达p_left，但是当左指针为p_left时，右指针还没有经过p_right左指针就移动了
已知当左指针停留在p_left时，它只有在两种场景下会发生改变
1、左指针和右指针在p_left相遇，则右指针一定在前往p_left的途中经过p_right，与题设矛盾
2、右指针位于p_right右侧且当前的值大于左指针。则在这种情况下，此时容器的盛水量比题设中最大的盛水量还要大，与题设矛盾
因此该算法的遍历一定经过了最大的盛水量的情况
 */
public class q11 {
	public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int resmax=0;
        int res=0;
        while(left<right) {
        	if (height[left]<height[right]) {
        		res=height[left]*(right-left);
        		left++;
        	}else {
        		res=height[right]*(right-left);
        		right--;
        	}
        	if (res>resmax) {
        		resmax=res;
        	}
        }
        return resmax;
    }
}
