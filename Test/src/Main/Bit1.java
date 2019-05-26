package Main;

import java.util.Scanner;

public class Bit1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] nums=new int[n];
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		int cur=nums[0],curi=0,res=0;
		for(int i=1;i<n;i++) {
			if(nums[i]+cur+curi-i>res) {
				res=nums[i]+cur+curi-i;
			}
			if(nums[i]>=cur-(i-curi)) {
				cur=nums[i];
				curi=i;
			}
		}
		System.out.println(res);
	}
}
