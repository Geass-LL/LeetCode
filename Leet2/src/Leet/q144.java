package Leet;

import java.util.*;

import DS.*;

/*
 * 我的思路：
 * 1、一路从根节点向左往下找，并堆栈。
 * 2、找不到则先POP，再看右节点，右节点也空再POP，再空再POP，直到非空，重复回1；如果空到empty，结束循环，返回结果。
 */

public class q144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
		if(root==null) return res;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		res.add(root.val);
		stack.add(root);
		while(!stack.isEmpty()) {
			if(root.left!=null) {
				res.add(root.left.val);
				stack.add(root.left);
				root=root.left;
			}else if(root.right!=null) {
				stack.pop();
				res.add(root.right.val);
				stack.add(root.right);
				root=root.right;
			}else {
				while(!stack.isEmpty()) {
					TreeNode temp=stack.pop();
					if(temp.right!=null) {
						res.add(temp.right.val);
						stack.add(temp.right);
						root=temp.right;
						break;
					}
				}
			}
		}
		return res;
    }
}
