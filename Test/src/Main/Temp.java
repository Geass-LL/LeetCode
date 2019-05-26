package Main;

import java.util.Scanner;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt();
		int[] nums=new int[n];
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
			System.out.println(nums[i]);
		}
	}

}
