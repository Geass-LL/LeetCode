package Main;

import java.util.*;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int alln=sc.nextInt();
		for(int j=0;j<alln;j++) {
			/*
			int n=sc.nextInt();
			int[] nums=new int[n];
			Stack<Integer> stk=new Stack<Integer>();
			for(int i=0;i<n;i++) {
				int cur=sc.nextInt();
				if(stk.isEmpty()||stk.peek()==cur) {
					stk.push(cur);
				}else {
					stk.pop();
				}
			}
			if(stk.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}*/
			int n=sc.nextInt();
			for(int i=0;i<n;i++) {
				int cur=sc.nextInt();
				if(map.containsKey(cur)) {
					map.put(cur,map.get(cur)+1);
				}else {
					map.put(cur, 1);
				}
			}
			List<Map.Entry<Integer, Integer>> list_Data = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
			Collections.sort(list_Data, new Comparator<Map.Entry<Integer, Integer>>(){   
				public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){  
					return o2.getValue().compareTo(o1.getValue());
		        } 
		    }); 
			int key0=map.get(list_Data.get(0).getKey());
			int value0=map.get(key0);
			int key1=map.get(list_Data.get(0).getKey());
			int value1=map.get(key1);
			if(value0==1) {
				map.remove(key0);
			}else {
				map.put(key0, map.get(key0)-1);
			}
			if(value1==1) {
				map.remove(key1);
			}else {
				map.put(key1, map.get(key1)-1);
			}
		}
	}
}
