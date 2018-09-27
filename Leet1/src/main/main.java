package main;

import java.util.List;

import Leet.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {-1, 0, 1, 2, -1, -4};
		q16 solution=new q16();
		int target=2;
		int res=solution.threeSumClosest(nums,target);
		System.out.println(res);
	}

}
