package main;

import java.util.*;

import DS.ListNode;
import Leet.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q31 solution=new q31();
		//------------------------------------------
		int[] nums= {1,4,3,3};
		solution.nextPermutation(nums);
		for(int num:nums) {
			System.out.println(num);
		}
	}
}
