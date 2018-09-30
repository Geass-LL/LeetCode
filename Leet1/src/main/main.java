package main;

import java.util.List;

import Leet.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q18 solution=new q18();
		int[] nums= {-1,-5,-5,-3,2,5,0,4};
		List<List<Integer>> res=solution.fourSum(nums, -7);
		System.out.println(res);
	}

}
