package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class NetEaseDictionary {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		char[] stemp=s.toCharArray();
		int n=0,k=0,ii=0;
		for (ii=0;ii<stemp.length;ii++) {
			if(stemp[ii]>='0'&&stemp[ii]<='9') {
				n=n*10+stemp[ii]-'0';
			}else {
				break;
			}
		}
		for(int j=ii+1;j<stemp.length;j++) {
			if(stemp[j]>='0'&&stemp[j]<='9'){
                k=k*10+stemp[j]-'0';
            }
		}
		System.out.println(n);
		System.out.println(k);
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
            list.add(i+1);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
            	char[] char1=String.valueOf(num1).toCharArray();
            	char[] char2=String.valueOf(num2).toCharArray();
                if(char1.length==char2.length) {
                	return (int)(num1-num2);
                }else {
                	int length=Math.min(char1.length, char2.length);
                	for(int i=0;i<length;i++) {
                		if(char1[i]!=char2[i]) {
                			return char1[i]-char2[i];
                		}
                	}
                	return char1.length-char2.length;
                }
            }
        });
        Iterator<Integer> iterator=list.iterator();
        int tempi=1;
        while (tempi<k){
        	tempi++;
            iterator.next();
        }
        System.out.println(iterator.next());
	}
}
