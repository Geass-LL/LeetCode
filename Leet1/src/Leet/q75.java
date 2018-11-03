package Leet;

public class q75 {
	public void sortColors(int[] nums) {
		int end0=-1,end1=-1,end2=-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				nums[++end2]=2;
				nums[++end1]=1;
				nums[++end0]=0;
			}else if(nums[i]==1) {
				nums[++end2]=2;
				nums[++end1]=1;
			}else {
				nums[++end2]=2;
			}
		}
    }
}
