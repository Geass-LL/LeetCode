package Leet;

import java.util.*;

/*
 * ע��Deque�ڴ洢���ǵ�ǰ���������ֵ�Ľ������С�
 * https://segmentfault.com/a/1190000003903509
 */

public class q239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] res=new int[nums.length-k+1];
		if(k<=1)	return nums;
		Deque<Integer> deque=new LinkedList<Integer>();
		for(int i=0;i<nums.length;i++) {
			while(deque.size()>0&&nums[i]>=nums[deque.getLast()]) {
				deque.removeLast();//���deque�е�ֵ�ܲ��Ҷ�С��i����ֵ����ô���ջ���ա�
			}
			deque.addLast(i);//������Σ�i����ֵ���ᱻ���뵽deque�У���������������С������һ���������ܻ����������
							//��������������������һ���������ᱻ�Ƴ�deque����������ֱ����롣
			if(i-k+1>=0) res[i-k+1]=nums[deque.getFirst()];
			if(i-k+1>=deque.getFirst()) deque.removeFirst();
		}
		return res;
    }
}
