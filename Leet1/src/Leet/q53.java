package Leet;
/*
 * 左右两边一起进发；
 */
public class q53 {
	public int maxSubArray(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int leftsum=nums[left++];
        int rightsum=nums[right--];
        int maxleft=leftsum;
        int maxright=rightsum;
        while(left<right) {
        	if(nums[left]+leftsum<nums[left]) {   
                leftsum=nums[left];
        	}
            else
        		leftsum+=nums[left];
            if(leftsum>maxleft)
                maxleft=leftsum;
        	left++;
        	if(nums[right]+rightsum<nums[right]) {
        		rightsum=nums[right];
        	}
        	else
        		rightsum+=nums[right];
            if(rightsum>maxright)
        		maxright=rightsum;
        	right--;
        }
        if(left==right){
            int maxsum=Math.max(maxleft, maxright);
            int addsidemaxsum=Math.max(leftsum+nums[left], rightsum+nums[left]);
            int addmaxsum=Math.max(addsidemaxsum, leftsum+rightsum+nums[left]);
            int maxtemp=Math.max(maxsum, addmaxsum);
            return Math.max(maxtemp, nums[left]);
        }else if(left==right+1){
            return Math.max(rightsum+leftsum,Math.max(maxleft,maxright));
        }else{
            return leftsum;
        }
    }
}
