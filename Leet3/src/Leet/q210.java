package Leet;

import java.util.*;

public class q210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer> list=new ArrayList<Integer>();
		
		if(prerequisites==null||prerequisites.length==0||prerequisites[0].length==0) {
			int[] nullres=new int[numCourses];
			for(int i=0;i<nullres.length;i++)	nullres[i]=i;
			return nullres;
		}
		
		int[] indegree=new int[numCourses];
		Queue<Integer> queue=new LinkedList<Integer>();
		int length=prerequisites.length;
		for(int i=0;i<length;i++) {
			indegree[prerequisites[i][0]]++;
		}
		for(int i=0;i<numCourses;i++) {
			if(indegree[i]==0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int temp=queue.poll();
			list.add(temp);
			for(int i=0;i<length;i++) {
				if(prerequisites[i][1]==temp) {
					indegree[prerequisites[i][0]]--;
					if(indegree[prerequisites[i][0]]==0) {
						queue.add(prerequisites[i][0]);
					}
				}
			}
		}
		if(list.size()==numCourses) {
			int[] res=new int[list.size()];
			for(int i=0;i<res.length;i++)	res[i]=list.get(i);
			return res;
		}else {
			return new int[] {};
		}
    }
}
