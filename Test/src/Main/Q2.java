package Main;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(),k=sc.nextInt();
		for(int alli=0;alli<t;alli++) {
			int count=0;
			int a=sc.nextInt(),b=sc.nextInt();
			for(int i=0;i*k<=b;i++) {
				if(i==0) {
					count+=b-a+1;
				}else {
					for(int j=Math.max(0, a-i*k);j<=b-i*k;j++) {
						count+=j+1;
					}
				}
			}
			System.out.println(count);
		}
	}

}
