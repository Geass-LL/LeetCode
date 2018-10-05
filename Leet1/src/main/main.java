package main;

import java.util.*;

import DS.ListNode;
import Leet.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q30 solution=new q30();
		//------------------------------------------
		String s="wordgoodgoodgoodbestword";
		String[] words= {"word","good","best","good"};
		List<Integer> res=solution.findSubstring(s, words);
		for (int eachres:res) {
			System.out.println(eachres);
		}
	}
}
