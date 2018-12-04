package Leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import DS.TreeNode;

/*
 * 我的思路：
 * 1、如果有左孩子，入栈；没有左孩子但有右孩子，入栈。
 * 2、左右都没有，出栈且记为temp，如果栈顶的右孩子不是temp，将栈顶右孩子入栈，重复1；否则再出栈且记为temp。
 * 		（上面的话可以理解为：如果temp不是栈顶的右孩子，也即temp此时为栈顶的左孩子，将栈顶右孩子入栈）。
 * 【以后自己不懂的话，直接画图走一遍就能理解了，关键是else里的语句】
 * 
 * 如果不判断栈顶的右孩子是否为temp直接出栈，将会是inorder。
 */

public class q145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
		if(root==null) return res;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.add(root);
		while(!stack.isEmpty()) {
			if(root.left!=null) {	//如果有左孩子，入栈
				stack.add(root.left);
				root=root.left;
			}else if(root.right!=null) {	//没有左孩子但有右孩子，入栈
				stack.add(root.right);
				root=root.right;
			}else {
				TreeNode temp=stack.pop();	//左右都没有，出栈且记为temp（这里能够确保栈非空，否则无法进入循环）
				res.add(temp.val);
				while(!stack.isEmpty()) {
					TreeNode last=stack.peek();	//peek()，因为不一定会出栈
					if(last.right!=null&&(last.right!=temp)) {	//栈顶的右孩子不是temp
						stack.add(last.right);
						root=last.right;
						break;
					}else {
						temp=stack.pop();	//否则（栈顶无右孩子或者栈顶的右孩子就是temp）栈顶出栈且记为temp。
						res.add(temp.val);
					}
				}
			}
		}
		return res;
    }
}
