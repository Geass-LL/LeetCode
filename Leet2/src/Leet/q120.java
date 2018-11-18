package Leet;

import java.util.*;

/*
 * res[i][j]表示到第i行的j位置最少需要多少步。
 * 为了实现空间复杂度为O(n)，修改为res[i]表示到当前行的i位置最少需要多少步，用temp1和temp2来保存计算下一步时需要的中间值。
 * 
 */

public class q120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int length=triangle.size();
		int[] res=new int[length];
        for(int i=0;i<length;i++) {
        	int temp1=res[0],temp2;
        	res[0]=res[0]+triangle.get(i).get(0);
        	for(int j=1;j<i;j++) {
        		temp2=res[j];
        		res[j]=Math.min(temp1, temp2)+triangle.get(i).get(j);
        		temp1=temp2;
        	}
        	if(i>0) {
        		res[i]=temp1+triangle.get(i).get(i);
        	}
        }
        int minnum=res[0];
        for(int i=1;i<length;i++) {
        	if(res[i]<minnum) {
        		minnum=res[i];
        	}
        }
        return minnum;
    }
}
