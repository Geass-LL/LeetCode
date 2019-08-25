package Main;
import java.util.Scanner;

public class WY1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] nums=new int[n];
		for(int i=0;i<n;i++) {
			nums[i]=n+1-sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			System.out.println(nums[i]);
		}
	}
}