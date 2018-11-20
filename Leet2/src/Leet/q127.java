package Leet;

import java.util.*;

public class q127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words=new HashSet(wordList);
        Set<String> visited=new HashSet();
        visited.add(beginWord);
        int dist=1;
        while(!visited.contains(endWord)) {
        	Set<String> temp=new HashSet();		//��Ҫ���½���һ��set�Դ洢��ǰ��ѭ����visited��
        	for(String visitedword:visited) {	//����visited�����ÿһ������
        		for(int i=0;i<visitedword.length();i++) {		//���ַ�������ÿ��λ�ã���a��j���λ���ȥ
        			char[] visitedchar=visitedword.toCharArray();	//�Ƚ���ת�����ַ�����
        			for(int j=(int)'a';j<(int)'z'+1;j++) {
        				visitedchar[i]=(char)j;
        				String visitedstr=String.valueOf(visitedchar);	//ת�����ַ���
        				if(words.contains(visitedstr)) {		//�������ַ�����words�ֵ��У����ֵ����Ƴ�������visited�м���
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
        	visited=temp;		//��temp���»�visited��
        }
        return dist;
    }
}
