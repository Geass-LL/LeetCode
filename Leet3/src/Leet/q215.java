package Leet;

import java.util.*;

public class q215 {
	public int findKthLargest(int[] nums, int k) {
        int L = 0, R = nums.length - 1;
        int n = nums.length;
        
        while(true) {
            int randIndex = getRandom(L, R);
            int partition = partition(nums, L, R, randIndex);
            
            if(partition == (n - k)) return nums[partition];
            else if(partition > (n - k)) R = partition - 1;
            else L = partition + 1;
        }
    }
    
    
    private int partition(int[] nums, int L, int R, int randIndex) {
        int partitionValue = nums[randIndex];
        swap(nums, randIndex, R);
        //ע�⣬������һ��Сϸ�ڣ��Ƚ�������ŵ����
        int newIndex = L;
        for(int i = L; i < R; ++i) {
            if(nums[i] < partitionValue) {
                swap(nums, i, newIndex++);
            }
        }
        //�ٰ�������Ż���
        swap(nums, newIndex, R);
        //��������Ч���Ǳ�֤newIndexλ��Ϊ�������ǰ�����е���������С��λ��Ҳ��ȷ���ģ�����ж����ͬ�Ŀ������õؽ����
        return newIndex;
    }
    
    private void swap(int[] nums, int indA, int indB) {
        if(indA == indB) return;
        int temp = nums[indA];
        nums[indA] = nums[indB];
        nums[indB] = temp;
    }
    
    private int getRandom(int a, int b) {
    	//can be a or b, if a, a+0; if b, a+b-a. So nextInt(b-a+1).
        Random rand = new Random();
        return a + rand.nextInt(b - a + 1);
    }
}
