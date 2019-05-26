package Leet;

import java.util.*;

public class q310 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> res=new ArrayList<Integer>();
		if(edges==null||edges.length==0) {
			res.add(0);
			return res;
		}
		Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
		for(int i=0;i<edges.length;i++) {
			int num1=edges[i][0],num2=edges[i][1];
			if(map.containsKey(num1)) {
				map.get(num1).add(num2);
			}else {
				List<Integer> temp=new ArrayList<Integer>();
				temp.add(num2);
				map.put(num1, temp);
			}
			if(map.containsKey(num2)) {
				map.get(num2).add(num1);
			}else {
				List<Integer> temp=new ArrayList<Integer>();
				temp.add(num1);
				map.put(num2, temp);
			}
		}
		boolean[] visited=new boolean[n];
		int height=n;
		for(int i=0;i<n;i++) {
			Arrays.fill(visited, false);
			Queue<Integer> q=new LinkedList<Integer>();
			q.add(i);
			visited[i]=true;
			int tempheight=help(visited,map,q,height);
			if(tempheight<height)	{
				res.clear();
				res.add(i);
				height=tempheight;
			}else if(tempheight==height) {
				res.add(i);
			}
		}
		return res;
    }
	int help(boolean[] visited,Map<Integer,List<Integer>> map,Queue<Integer> q,int height) {
		int qsize=q.size();
		if(qsize==0)	return 0;
		if(height<0)	return 0;
		for(int i=0;i<qsize;i++) {
			for(int each:map.get(q.poll())) {
				if(!visited[each]) {
					visited[each]=true;
					q.add(each);
				}
			}
		}
		return help(visited,map,q,height-1)+1;
	}
}
