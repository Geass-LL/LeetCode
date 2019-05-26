package Main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		float[] nums=new float[n];
		for(int i=0;i<n;i++) {
			String temp=sc.nextLine();
			nums[i]=Float.valueOf(temp);
			System.out.println(nums[i]);
		}
	}
}
