package Main;

import java.util.*;

public class HW3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="RmApp|RmAppAttempt_001|start RmApp|RmAppAttempt_002|start RmApp|RmAppAttempt_001|kill";
		String[] events=str.split(" ");
		Map<String,Integer> map=new HashMap<String,Integer>();
		for(int i=0;i<events.length;i++) {
			String temp=events[i];
			temp=temp.replace('|', ' ');
			String[] values=temp.split(" ");
			System.out.println(values.length);
			if(values.length==3) {
				if(map.containsKey(values[1])&&map.get(values[1])!=0) {
					if(map.get(values[1])!=5&&values[0].equals("RmApp")&&values[2].equals("kill")) {
						map.put(values[1], 0);
						System.out.println(values[1]+"|"+"killed;");
					}
					if(map.get(values[1])==1&&values[0].equals("ResouceScheduler")&&values[2].equals("app_accepted")) {
						map.put(values[1], 2);
						System.out.println(values[1]+"|"+"scheduled;");
					}else if(map.get(values[1])==2) {
						if(values[0].equals("RmContainer")&&values[2].equals("container_accepted")) {
							map.put(values[1], 3);
							System.out.println(values[1]+"|"+"allocated;");
						}else if(values[0].equals("ApplicationMasterLauncher")&&values[2].equals("launched")) {
							map.put(values[1], 4);
							System.out.println(values[1]+"|"+"running;");
						}
					}else if(map.get(values[1])==4&&values[0].equals("ResouceScheduler")&&values[2].equals("finished")) {
						map.put(values[1], 5);
						System.out.println(values[1]+"|"+"finished;");
					}
				}else {
					if(values[0].equals("RmApp")&&values[2].equals("start")) {
						map.put(values[1], 1);
						System.out.println(values[1]+"|"+"submitted;");
					}
				}
			}
		}
	}

}
