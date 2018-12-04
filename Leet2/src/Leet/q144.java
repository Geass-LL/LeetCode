package Leet;

import java.util.*;

import DS.*;

/*
 * �ҵ�˼·��
 * 1��һ·�Ӹ��ڵ����������ң�����ջ��
 * 2���Ҳ�������POP���ٿ��ҽڵ㣬�ҽڵ�Ҳ����POP���ٿ���POP��ֱ���ǿգ��ظ���1������յ�empty������ѭ�������ؽ����
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
