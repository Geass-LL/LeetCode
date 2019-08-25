package Main;

import java.util.Scanner;

public class WY4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String s=sc.nextLine();
			String t=sc.nextLine();
			char[] chs=s.toCharArray();
			boolean end=false;
			int k=0;
			for(int j=0;j<s.length();j++) {
				chs[j]=(char) ('0'+('1'-chs[j]));
				if(chs[j]=='0'&&!end)	k++;
				else	end=true;
				
			}
			String revs=String.valueOf(chs).substring(k);
			int lengths=s.length(),lengthr=revs.length();
			i=0;
			while(i<t.length()) {
				if(lengthr>lengths) {
					if(i+lengthr<=t.length()&&revs.equals(t.substring(i, i+lengthr))) {
						i+=lengthr;
					}else if(i+lengths<=t.length()&&s.equals(t.subSequence(i, i+lengths))) {
						i+=lengths;
					}else {
						break;
					}
				}else {
					if(i+lengths<=t.length()&&s.equals(t.subSequence(i, i+lengths))) {
						i+=lengths;
					}else if(i+lengthr<=t.length()&&revs.equals(t.substring(i, i+lengthr))) {
						i+=lengthr;
					}else {
						break;
					}
				}
			}
			System.out.println(i);
			if(i>=t.length()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

}
