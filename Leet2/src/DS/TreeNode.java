package DS;

import java.util.*;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x){val=x;}
	public void Show() {
	//n��ʾnull��n���޽ڵ㣻�����ʾ��
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(this);
		while(!queue.isEmpty()) {
			int pushsize=queue.size();
			while(pushsize>0) {
				TreeNode tempnode=queue.poll();
                pushsize--;
				if(tempnode!=null) {
					System.out.print(tempnode.val);
					System.out.print(",");
					queue.add(tempnode.left);
					queue.add(tempnode.right);
				}else {
					System.out.print("n,");
				}
			}
			System.out.println();
		}
    }
}
