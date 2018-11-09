package DS;

import java.util.*;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x){val=x;}
	public void Show() {
		List<Integer> showtemp=new ArrayList();
		traverse(showtemp,this);
		for(int eachint:showtemp) {
			System.out.print(eachint);
			System.out.print(" ");
		}
	}
	public void traverse(List<Integer> res,TreeNode root) {
		if(root!=null) {
			traverse(res,root.left);
			res.add(root.val);
			traverse(res,root.right);
		}
	}
}
