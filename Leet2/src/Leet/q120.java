package Leet;

import java.util.*;

/*
 * res[i][j]��ʾ����i�е�jλ��������Ҫ���ٲ���
 * Ϊ��ʵ�ֿռ临�Ӷ�ΪO(n)���޸�Ϊres[i]��ʾ����ǰ�е�iλ��������Ҫ���ٲ�����temp1��temp2�����������һ��ʱ��Ҫ���м�ֵ��
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
