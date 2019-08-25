package Main;

import java.util.Arrays;
import java.util.Scanner;

public class WY2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int K=sc.nextInt();
        for(int k=0;k<K;k++){
            int n=sc.nextInt();
            int[] nums=new int[n];
		    for(int i=0;i<n;i++) {
			    nums[i]=sc.nextInt();
		    }
		    Arrays.sort(nums);
		    int left=0,right=n-1;
		    
        }
	}
}
