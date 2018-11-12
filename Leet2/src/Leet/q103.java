package Leet;

import java.util.*;
import DS.TreeNode;
/*
 * 使用了两个栈，一个栈用于存储当前的结果即储存到prevstack中； 
 * 另外一个栈是把储存的值恢复出来；
 * 使用leftflag来控制zigzag的方向。
 */
public class q103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(root==null) {
			return res;
		}else {
			Stack<TreeNode> prevstack=new Stack<TreeNode>();
			prevstack.push(root);
			boolean leftflag=true;
			while(prevstack.size()>0) {
				Stack<TreeNode> stack=prevstack;
				prevstack=new Stack<TreeNode>();
				List<Integer> curlevel=new ArrayList<Integer>();
				while(!stack.isEmpty()) {
					TreeNode tempnode=stack.pop();
					curlevel.add(tempnode.val);
					if(leftflag) {
						if(tempnode.left!=null) {
							prevstack.push(tempnode.left);
						}
						if(tempnode.right!=null) {
							prevstack.push(tempnode.right);
						}
					}else {
						if(tempnode.right!=null) {
							prevstack.push(tempnode.right);
						}
						if(tempnode.left!=null) {
							prevstack.push(tempnode.left);
						}
					}
				}
				res.add(curlevel);
				leftflag=!leftflag;
			}
			return res;
		}
    }
}
