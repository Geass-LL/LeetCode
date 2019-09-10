package Leet;

public class qtemp {
	public int[] choose(int[] nums,int k) {
		int[] res = new int[k];
		int length=nums.length;
		int j=0;
		for(int i=0;i<nums.length;i++) {
			while(j>0&&length-i+j>k&&res[j-1]<nums[i]) {//
				j--;
			}
			if(j<k) {
				res[j++]=nums[i];
			}
			for(int m=0;m<j;m++) {
				System.out.print(String.valueOf(res[m])+" ");
			}
			System.out.println("["+String.valueOf(i)+","+String.valueOf(j)+"]");
		}
		return res;
	}
}
