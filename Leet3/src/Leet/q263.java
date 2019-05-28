package Leet;

public class q263 {
	public boolean isUgly(int num) {
		if(num==0) return false;
		int[] nums= {2,3,5};
		for(int i=0;i<nums.length;i++) {
			while(num%nums[i]==0) {
				num/=nums[i];
			}
		}
		return num==1;
    }
}
