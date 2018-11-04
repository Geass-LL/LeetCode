package Leet;

/*
 * two pointers£¬±È½Ï¼òµ¥¡£
 */
public class q80 {
    public int removeDuplicates(int[] nums) {
    	int length=nums.length;
    	if(length<=2) {
    		return length;
    	}
    	/*
    	int left=1,count=0;
    	for(int right=1;right<length;right++) {
    		if(nums[right]!=nums[right-1]) {
    			nums[left]=nums[right];
    			left++;
    			count=0;
    		}
    		else {
    			if(count<1) {
    				count++;
    				nums[left]=nums[right];
    				left++;
    			}
    		}
    	}*/
    	int left=2;
    	for(int right=2;right<length;right++) {
    		if(nums[right]>nums[left-2]) {
    			nums[left]=nums[right];
    			left++;
    		}
    	}
    	return left;
    }
}
