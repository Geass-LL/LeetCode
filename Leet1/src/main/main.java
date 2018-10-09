package main;

import java.util.*;

import DS.ListNode;
import Leet.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q36 solution=new q36();
		//------------------------------------------
		char[][] test= {{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','9','.','.','.','.','.','.','1'},{'8','.','.','.','.','.','.','.','.'},{'.','9','9','3','5','7','.','.','.'},{'.','.','.','.','.','.','.','4','.'},{'.','.','.','8','.','.','.','.','.'},{'.','1','.','.','.','.','4','.','9'},{'.','.','.','5','.','4','.','.','.'}};
		System.out.println(solution.isValidSudoku(test));
	}
}
