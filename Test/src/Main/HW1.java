package Main;

import java.util.*;

public class HW1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		char[] ch=str.toCharArray();
		int[] nums=new int[str.length()];
		char[] flags=new char[str.length()];
		int tempres=0,j=0;
		for(int i=0;i<ch.length;i++) {
			if(ch[i]<='9'&&ch[i]>='0') {
				tempres=tempres*10+ch[i]-'0';
			}else if(ch[i]=='+') {
				nums[j]=tempres;
				flags[j]='+';
				j++;
				tempres=0;
			}else if(ch[i]=='-') {
				nums[j]=tempres;
				flags[j]='-';
				j++;
				tempres=0;
			}
		}
		nums[j]=tempres;
		for(int i=1;i<=j;i++) {
			if(flags[i-1]=='+')
				nums[i]=nums[i-1]+nums[i];
			if(flags[i-1]=='-') 
				nums[i]=nums[i-1]-nums[i];
		}
		System.out.println(nums[j]);
	}

}
