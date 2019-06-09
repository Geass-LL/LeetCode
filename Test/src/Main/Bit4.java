package Main;

import java.util.*;

public class Bit4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine(),t=sc.nextLine();
		String[] ts=t.split(" ");
		Map<String,Boolean> map=new HashMap<String,Boolean>();
		for(String eacht:ts) {
			map.put(eacht, false);
		}
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<=s.length();j++) {
				String key=s.substring(i, j);
				if(map.containsKey(key)) {
					map.put(key, true);
				}
			}
		}
		for(String eacht:ts) {
			if(!map.get(eacht)) {
				System.out.println(false);
				return;
			}
		}
		System.out.println(true);
	}
}
