package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * ����˼�룺
 * ����
 *     a
 *    /  \
 *   b    c
 *  /\    /\
 * d  e  f  g
 * ������Ϊ��[a,b,d,e,c,f,g]
 * ������Ϊ��[d,b,e,a,f,c,g]
 * 1������Ϊ�գ�
 * 2���������е�ÿ��Ԫ�أ�
 * 		������������У������������������������鵽�����У����ǵ��Һ��ӿ�ʼ
 * 						 ֻ��������ֱ�����򼯰���������Ԫ�أ���û������Ϊ��ʼ��
 * 								a			 a			  a���ǣ�
 * 							   /			/		   /     \
 * 							  b			   b(��)		  b       c�����ǵ��Һ��ӿ�ʼ��
 * 							 /			  / \	     / \     /
 * 							d			 d   e		d   e   f(ֻ�������ӣ�ֱ������������Ԫ�أ�
 * 		������������У��������κβ�������¼��λ��Ϊ��.ִ����һ������Ԫ�أ�
 * 
 * ���򼯿�����ջ�ṹ���ӷ��㣬������tempnode���ڼ�¼�ǵ�λ�á�
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
