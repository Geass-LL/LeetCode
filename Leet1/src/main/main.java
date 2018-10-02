package main;

import java.util.List;

import DS.ListNode;
import Leet.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q22_succ solution=new q22_succ();
		int test=8;
		for (String eachres:solution.generateParenthesis(test)) {
			System.out.println(eachres);
		}
	}

}
