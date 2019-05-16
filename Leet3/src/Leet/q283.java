package Leet;

public class q283 {
	public void moveZeroes(int[] nums) {
		/*这是用的交换的思路完成的
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				int j=i+1;
				while(j<nums.length) {
					if(nums[j]!=0) {
						nums[i]=nums[j];
						nums[j]=0;
						break;
					}
					j++;
				}
				if(j>=nums.length)	break;
			}
		}*/
		//下面的思路，直接就不交换！也就是说非0的在前面，剩下的全人为置0即可
		int i=0,i1=0;
		while(i<nums.length) {
			if(nums[i]!=0) {
				nums[i1]=nums[i];
				i1++;
			}
			i++;
			while(i<nums.length&&nums[i]==0) {
				i++;
			}
		}
		for(i=i1;i<nums.length;i++) {
			nums[i]=0;
		}
    }
}
