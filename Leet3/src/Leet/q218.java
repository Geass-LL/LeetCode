package Leet;

import java.util.*;

public class q218 {
	/*
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res =new ArrayList<int[]>();
		if(buildings==null||buildings.length==0||buildings[0].length==0)	return res;
		List<int[]> height=new ArrayList<int[]>();
		for(int i=0;i<buildings.length;i++) {
			height.add(new int[] {buildings[i][0],buildings[i][2]});
			height.add(new int[] {buildings[i][0],-buildings[i][2]});
		}
		Collections.sort(height,new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				if(o1[0]==o2[0])	return o2[1]-o1[1];
				else	return o1[0]-o2[0];
			}
		});
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1,Integer o2) {
				return o2-o1;
			}
		});
		queue.offer(0);
		int cur=0,pre=0;
		for(int[] h:height) {
			if(h[1]>0) {
				queue.offer(h[1]);
			}else {
				queue.remove(-h[1]);
			}
			cur=queue.peek();
			if(pre!=cur) {
				res.add(new int[] {h[0],cur});
				pre=cur;
			}
		}
		return res;
    }*/
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
				}
				else {
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
}
