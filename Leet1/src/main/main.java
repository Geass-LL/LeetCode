package main;

import java.util.List;

import DS.ListNode;
import Leet.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q26 solution=new q26();
		int[] test= {};
		int length=solution.removeDuplicates(test);
		System.out.println(length);
		for (int i=0;i<length;i++) {
			System.out.println(test[i]);
		}
			
	}
}
