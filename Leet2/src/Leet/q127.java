package Leet;

import java.util.*;

public class q127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words=new HashSet(wordList);
        Set<String> visited=new HashSet();
        visited.add(beginWord);
        int dist=1;
        while(!visited.contains(endWord)) {
        	Set<String> temp=new HashSet();		//需要重新建立一个set以存储当前轮循环的visited。
        	for(String visitedword:visited) {	//对于visited里面的每一个词语
        		for(int i=0;i<visitedword.length();i++) {		//将字符数组中每个位置，从a到j依次换过去
        			char[] visitedchar=visitedword.toCharArray();	//先将其转换成字符数组
        			for(int j=(int)'a';j<(int)'z'+1;j++) {
        				visitedchar[i]=(char)j;
        				String visitedstr=String.valueOf(visitedchar);	//转换回字符串
        				if(words.contains(visitedstr)) {		//如果这个字符串在words字典中，从字典中移除，并在visited中加入
        					words.remove(visitedstr);
        					temp.add(visitedstr);
        				}
        			}
        		}
        	}
        	if(temp.size()==0) {
        		return 0;
        	}
        	dist++;
        	visited=temp;		//把temp更新回visited。
        }
        return dist;
    }
}
