package Leet;

import java.util.*;

public class q126 {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<Set<String>> soluset=new ArrayList<Set<String>>();
		List<List<String>> res=new ArrayList<List<String>>();
		Set<String> words=new HashSet<String>(wordList);
		Set<String> visited=new HashSet<String>();
		visited.add(beginWord);
		soluset.add(visited);
		while(!visited.contains(endWord)) {
			Set<String> curvisited=new HashSet<String>();
			for(String eachvisited:visited) {
				for(String alterword:Neis(eachvisited)) {
					if(words.contains(alterword)) {
						words.remove(alterword);
						curvisited.add(alterword);
					}
				}
			}
			if(curvisited.size()==0) return res;
			visited=curvisited;
			soluset.add(visited);
		}
		int dist=soluset.size();
		List<String> tempres=new ArrayList<String>();
		tempres.add(beginWord);
		btk(res,tempres,1,dist,soluset,endWord);
		return res;
    }
	List<String> Neis(String instr) {
		List<String> res=new ArrayList<String>();
		for(int i=0;i<instr.length();i++) {
			char[] temp=instr.toCharArray();
			for(int j=(int)'a';j<=(int)'z';j++) {
				temp[i]=(char)j;
				res.add(String.valueOf(temp));
			}
		}
		return res;
	}
	void btk(List<List<String>> res,List<String> tempres, int deep,int dist, List<Set<String>> soluset,String endWord) {
		if(deep==dist) {
			if(tempres.get(deep-1).equals(endWord)) {
				res.add(new ArrayList(tempres));
			}else {
				return;
			}
		}else {
			for(String eachstr:Neis(tempres.get(tempres.size()-1))) {
				if(soluset.get(deep).contains(eachstr)) {
					tempres.add(eachstr);
					btk(res,tempres,deep+1,dist,soluset,endWord);
					tempres.remove(tempres.size()-1);
				}
			}
		}
	}
	boolean isNei(String str1,String str2) {
		char[] cha1=str1.toCharArray(),cha2=str2.toCharArray();
		int temp=0;
		for(int i=0;i<str1.length();i++) {
			if(cha1[i]!=cha2[i]) {
				temp++;
			}
			if(temp>1) {
				return false;
			}
		}
		return true;
	}
}
