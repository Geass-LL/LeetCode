package Leet;

/*
 *¼ûonenote 
 */

public class q31 {
	public void nextPermutation(int[] nums) {
		int i=nums.length-1;
		boolean flag=true;
		while(i>0) {
			if(nums[i]<=nums[--i]) {
			}
			else {
				flag=false;
				int minnum=nums[i+1];
				int sli=i+1;
				for(int j=i+1;j<=nums.length-1;j++) {
					if(nums[j]>nums[i]&&nums[j]<minnum) {
						minnum=nums[j];
						sli=j;
					}
				}
				int temp=nums[i];
				nums[i]=nums[sli];
				nums[sli]=temp;
				reverse(nums,i+1);
				break;
			}
		}
		if(flag) {
			reverse(nums,0);
		}
    }
	void reverse(int[] nums,int k) {
		for(int i=k;i<nums.length;i++) {
			int j=nums.length-1;
			while(j>k) {
				if(nums[j]<=nums[j-1]) {
					int temp=nums[j];
					nums[j]=nums[j-1];
					nums[j-1]=temp;
				}
				j--;
			}
		}
	}
}
