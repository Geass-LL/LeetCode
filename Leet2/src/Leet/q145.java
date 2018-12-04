package Leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import DS.TreeNode;

/*
 * �ҵ�˼·��
 * 1����������ӣ���ջ��û�����ӵ����Һ��ӣ���ջ��
 * 2�����Ҷ�û�У���ջ�Ҽ�Ϊtemp�����ջ�����Һ��Ӳ���temp����ջ���Һ�����ջ���ظ�1�������ٳ�ջ�Ҽ�Ϊtemp��
 * 		������Ļ��������Ϊ�����temp����ջ�����Һ��ӣ�Ҳ��temp��ʱΪջ�������ӣ���ջ���Һ�����ջ����
 * ���Ժ��Լ������Ļ���ֱ�ӻ�ͼ��һ���������ˣ��ؼ���else�����䡿
 * 
 * ������ж�ջ�����Һ����Ƿ�Ϊtempֱ�ӳ�ջ��������inorder��
 */

public class q145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
		if(root==null) return res;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.add(root);
		while(!stack.isEmpty()) {
			if(root.left!=null) {	//��������ӣ���ջ
				stack.add(root.left);
				root=root.left;
			}else if(root.right!=null) {	//û�����ӵ����Һ��ӣ���ջ
				stack.add(root.right);
				root=root.right;
			}else {
				TreeNode temp=stack.pop();	//���Ҷ�û�У���ջ�Ҽ�Ϊtemp�������ܹ�ȷ��ջ�ǿգ������޷�����ѭ����
				res.add(temp.val);
				while(!stack.isEmpty()) {
					TreeNode last=stack.peek();	//peek()����Ϊ��һ�����ջ
					if(last.right!=null&&(last.right!=temp)) {	//ջ�����Һ��Ӳ���temp
						stack.add(last.right);
						root=last.right;
						break;
					}else {
						temp=stack.pop();	//����ջ�����Һ��ӻ���ջ�����Һ��Ӿ���temp��ջ����ջ�Ҽ�Ϊtemp��
						res.add(temp.val);
					}
				}
			}
		}
		return res;
    }
}
