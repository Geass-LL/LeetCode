package Leet;

import java.util.*;

/*
 * 注意Deque内存储的是当前窗口内最大值的降序排列。
 * https://segmentfault.com/a/1190000003903509
 */

public class q239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] res=new int[nums.length-k+1];
		if(k<=1)	return nums;
		Deque<Integer> deque=new LinkedList<Integer>();
		for(int i=0;i<nums.length;i++) {
			while(deque.size()>0&&nums[i]>=nums[deque.getLast()]) {
				deque.removeLast();//如果deque中的值很不幸都小于i处的值，那么最终会清空。
			}
			deque.addLast(i);//无论如何，i处的值都会被加入到deque中，如果后面的数比它小，在下一步中它可能会继续保留，
							//如果后面的数比它大，在下一步中它将会被移出deque，后面的数又被移入。
			if(i-k+1>=0) res[i-k+1]=nums[deque.getFirst()];
			if(i-k+1>=deque.getFirst()) deque.removeFirst();
		}
		return res;
    }
}
