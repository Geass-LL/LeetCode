package Leet;

import java.util.*;

public class q207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(prerequisites==null||prerequisites.length==0||prerequisites[0].length==0) return true;
		int[] indegree=new int[numCourses];
		for(int[] edge:prerequisites) {
			indegree[edge[0]]++;
		}
		Queue<Integer> queue=new LinkedList<Integer>();
		List<Integer> res=new ArrayList<Integer>();
		for(int i=0;i<numCourses;i++) {
			if(indegree[i]==0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int src=queue.poll();
			res.add(src);
			for(int[] edge:prerequisites) {
				if(edge[1]==src) {
					indegree[edge[0]]--;
					if(indegree[edge[0]]==0)
						queue.add(edge[0]);
				}
			}
		}
		return res.size()==numCourses;
    }
}
