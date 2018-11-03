package Leet;

public class q75 {
	public void sortColors(int[] nums) {
		int start0=-1,start1=-1,start2=-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				nums[++start2]=2;
				nums[++start1]=1;
				nums[++start0]=0;
			}else if(nums[i]==1) {
				nums[++start2]=2;
				nums[++start1]=1;
			}else {
				nums[++start2]=2;
			}
		}
    }
}
