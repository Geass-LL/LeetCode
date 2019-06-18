package Leet;

import java.util.*;

public class q767 {
	class pair{
		public char ch;
		public int num;
		public pair(char ch,int num) {
			this.ch=ch;
			this.num=num;
		}
	}
	public String reorganizeString(String S) {
		if(S.length()<=1)	return S;
		StringBuilder s=new StringBuilder();
		int[] counts=new int[26];
		for(int i=0;i<S.length();i++) {
			counts[S.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++) {
			if(counts[i]>(S.length()+1)/2)	return "NULL";
		}
		List<pair> temp=new ArrayList<pair>();
		for(int i=0;i<26;i++) {
			if(counts[i]!=0) {
				temp.add(new pair((char)('a'+i),counts[i]));
			}
		}
		PriorityQueue<pair> queue=new PriorityQueue<pair>(new Comparator<pair>(){
			public int compare(pair o1, pair o2) {
				return o2.num-o1.num;
			}
		});
		for(int i=0;i<26;i++) {
			if(counts[i]!=0) {
				queue.add(new pair((char)('a'+i),counts[i]));
			}
		}
		while(queue.size()>=2) {
			pair o1=queue.poll(), o2=queue.poll();
			for(int count=0;count<o2.num;count++) {
				s.append(o1.ch);
				s.append(o2.ch);
			}
			if(o1.num>o2.num) {
				o1.num=o1.num-o2.num;
				queue.add(o1);
			}
		}
		if(!queue.isEmpty()) {
			pair last=queue.poll();
			if(last.num==1) {
				s.append(last.ch);
				return s.toString();
			}
		}
		return s.toString();
    }
}
