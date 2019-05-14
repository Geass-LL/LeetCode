package Leet;

import java.util.*;

/*
 * 两种解法，具体可以看Onenote.
 */

public class q218 {
	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> res = new ArrayList<>();
		if (buildings == null || buildings.length == 0) return res;

		PriorityQueue<E> queue = queue(buildings);
		PriorityQueue<Integer> hs = new PriorityQueue<>(Comparator.reverseOrder());
		hs.add(0);
		while (!queue.isEmpty()) {
			E e = queue.remove();
			if (e.left) {
				if (hs.peek() < e.y) res.add(Arrays.asList(e.x, e.y));
				hs.add(e.y);
			}else {
				hs.remove(e.y);
				if (hs.peek() < e.y) res.add(Arrays.asList(e.x, hs.peek()));
			}
		}
		return res;
	}

	public PriorityQueue<E> queue(int[][] buildings) {
		PriorityQueue<E> queue = new PriorityQueue<>(new Comparator<E>() {
			@Override
			public int compare(E e1, E e2) {
				if (e1.x != e2.x) return e1.x-e2.x;
				if (e1.left != e2.left) return (e1.left) ? -1 : 1;
				return (e1.left) ? e2.y-e1.y : e1.y-e2.y;
			}
		});
		for (int[] b : buildings) {
			queue.add(new E(b[0], b[2], true));
			queue.add(new E(b[1], b[2], false));
		}
		return queue;
	}

	class E {
		int x, y;
		boolean left;
		public E(int X, int Y, boolean Left) {
			x = X; y = Y; left = Left;
		}        
	}
	/*
	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		PriorityQueue<Integer> height=new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Pair> queue=new PriorityQueue<Pair>();
		for(int[] build:buildings) {
			queue.add(new Pair(build[0],-build[2]));
			queue.add(new Pair(build[1],build[2]));
		}
		int pre=0;
		while(!queue.isEmpty()) {
			Pair pair=queue.poll();
			if(pair.height<0) {
				height.add(-pair.height);
			}else {
				height.remove(pair.height);
			}
			if(!height.isEmpty()) {
				int cur=height.peek();
				if(pre!=cur) {
					res.add(Arrays.asList(pair.point,cur));
					pre=cur;
				}
			}else {
				res.add(Arrays.asList(pair.point,0));
			}
		}
		return res;
	}
	class Pair implements Comparable <Pair>{
		int point;
		int height;
		Pair(int inpoint,int inheight){
			point=inpoint;
			height=inheight;
		}
		public int compareTo(Pair o) {
			if(o.point!=point)	return point-o.point;
			else	return height-o.height;
		}
	}*/
}
