package Leet;

import DS.TreeNode;

/*�Լ���ô���벻���ء�
 * ע���˼ҵ�д�����Ӻ����ķ���ֵ�Ǹýڵ���ʼ����󳤶ȣ�
 * ������������µ�ʱ���Ƕ�ÿ���ڵ㶼������ͨ��������������ܳ��ȡ�
 */

public class q124_new {
	public int maxnum=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if(root==null) {
			return 0;
		}
		cacu(root);
		return maxnum;
    }
	public int cacu(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int temp=root.val,llen=cacu(root.left),rlen=cacu(root.right);
		//�ڼ�����󳤶�ʱ���Ըýڵ�Ϊroot����󳤶�
		if(llen>0) {
			temp+=llen;
		}
		if(rlen>0) {
			temp+=rlen;
		}
		if(temp>maxnum) {
			maxnum=temp;
		}
		//�ڼ�����󳤶�ʱ���Ըýڵ�Ϊroot����󳤶�
		return Math.max(root.val, Math.max(root.val+llen, root.val+rlen));//���ؽ��Ϊ�Ըýڵ�Ϊ��ʼ�ĵ�����󳤶�
	}
}
