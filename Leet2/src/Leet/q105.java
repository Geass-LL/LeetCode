package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * 核心思想：
 * 对于
 *     a
 *    /  \
 *   b    c
 *  /\    /\
 * d  e  f  g
 * 其先序为：[a,b,d,e,c,f,g]
 * 其中序为：[d,b,e,a,f,c,g]
 * 1、先序集为空；
 * 2、对中序中的每个元素：
 * 		如果不在先序集中：从先序数组中依次新增数组到先序集中，从星的右孩子开始
 * 						 只延拓左孩子直到先序集包括了中序元素；（没有星则为起始）
 * 								a			 a			  a（星）
 * 							   /			/		   /     \
 * 							  b			   b(星)		  b       c（从星的右孩子开始）
 * 							 /			  / \	     / \     /
 * 							d			 d   e		d   e   f(只延拓左孩子，直到包括了中序元素）
 * 		如果存在先序集中：不用做任何操作，记录该位置为星.执行下一个中序元素；
 * 
 * 先序集可以用栈结构更加方便，程序中tempnode用于记录星的位置。
 */

public class q105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Stack<TreeNode> stack=new Stack<TreeNode>();
		int prei=0,ini=0,length=preorder.length;
		TreeNode tempnode=null,res=null;
		while(ini<length) {
			if(stack.isEmpty()) {
				if(res==null) {
					res=new TreeNode(preorder[prei++]);
					stack.push(res);
				}else {
					TreeNode cur=new TreeNode(preorder[prei++]);
					tempnode.right=cur;
					stack.push(cur);
					tempnode=null;
				}
			}else if(stack.peek().val!=inorder[ini]) {
				TreeNode cur=new TreeNode(preorder[prei++]);
				if(tempnode==null) {
					stack.peek().left=cur;
					stack.push(cur);
				}else {
					tempnode.right=cur;
					stack.push(cur);
					tempnode=null;
				}
			}else {
				tempnode=stack.pop();
				ini++;
			}
		}
		return res;
    }
}
