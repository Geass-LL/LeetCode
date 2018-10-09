package main;

import java.util.*;

import DS.ListNode;
import Leet.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q34 solution=new q34();
		//------------------------------------------
		int[] nums= {1,2,3,3,3,3,4,5,9};
		int[] res=solution.searchRange(nums,3);
		for(int eachres:res) {
			System.out.println(eachres);
		}
	}
}
