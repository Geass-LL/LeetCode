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
        //注意，这里有一个小细节：先将随机数放到最后
        int newIndex = L;
        for(int i = L; i < R; ++i) {
            if(nums[i] < partitionValue) {
                swap(nums, i, newIndex++);
            }
        }
        //再把随机数放回来
        swap(nums, newIndex, R);
        //这样做的效果是保证newIndex位置为随机数，前面所有的数都比它小，位置也是确定的；如果有多个相同的可以良好地解决。
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
