package Main;

import java.util.*;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		String T=sc.nextLine();
		int m=sc.nextInt();
		int res=0;
		sc.nextLine();
		for(int i=0;i<m;i++) {
			String s=sc.nextLine();
			String scmp="";
			int slength=s.length();
			int srem=n%slength,times=n/slength;
			for(int j=0;j<times;j++) {
				scmp+=s;
			}
			scmp+=s.substring(0,srem);
			System.out.println(scmp);
			if(scmp.equals(T)) {
				res++;
			}
		}
		System.out.println(res);
	}

}
