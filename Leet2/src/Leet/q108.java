package Leet;

import DS.TreeNode;
import java.util.*;

/*
 * 都是采用递归的办法。
 */
public class q108 {
	public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode res=new TreeNode(0);
		int length=nums.length;
		if(length==0) {
			return null;
		}else {
			res.val=nums[length/2];
			res.left=sortedArrayToBST(Arrays.copyOfRange(nums, 0, length/2));
			res.right=sortedArrayToBST(Arrays.copyOfRange(nums, length/2+1, length));
			return res;
		}
    }
}
