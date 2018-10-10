package Leet;

import java.util.*;
/*
 * �ö�̬�滮���ġ�������Էֽ��������������⣺
 * 1��ʹ�õ�һ��������ʹ��1-N�ε�һ�����ĺ�firstsum�����ʣ�����ݵĺ�Ϊtarget-firstsum�����⣻
 * 2����ʹ�õ�һ���������ʣ�����ݺ�Ϊtarget�����⡣
 * ��Ҫע�⣺list��addAll����������null��Ϊ������
 */
public class q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> res=dyp(candidates,0,candidates.length,target);
    	return res;
    }
    List<List<Integer>> dyp(int[] candidates,int from,int to,int target){
    	//��ֹ����
    	if(from>=to) {
    		return null;
    	}
    	List<Integer> samenum=new ArrayList<Integer>();//��һ�����ظ�����
    	List<List<Integer>> res=new ArrayList<List<Integer>>();//���ս��
    	int firstsum=candidates[from],curnum=candidates[from];//��һ�������ۼӼ���һ������
    	from++;//��һ������
    	while(firstsum<target) {//��һ��N�κ�һ��ҪС��Ŀ��ֵ
    		samenum.add(curnum);//��һ�����Ľⲿ��
    		List<List<Integer>> tempres1=dyp(candidates,from,candidates.length,target-firstsum);//�����ⲿ��
    		if(tempres1!=null) {//�ǿ�
	    		for(List<Integer> eachlist:tempres1) {
	    			eachlist.addAll(samenum);//�ѵ�һ������ֵ�������ⲿ�ֺϲ�
	    			res.add(eachlist);//��Ϊ���ս����һ�����н�
	    		}
    		}
    		firstsum+=curnum;//��һ����N->N+1��
    	}
    	if(firstsum==target){//��Ҫ����������������������������������Ҫ
    		samenum.add(curnum);//from=0��ʱ�����ǰѵ�һ�����ӽ�ȥ��
    		res.add(samenum);//����һ���������Ŀ��н�
    	}
    	List<List<Integer>> tempres2=dyp(candidates,from,candidates.length,target);//�ڶ���������
    	if(tempres2!=null)//�ǿ�
    		res.addAll(tempres2);
    	return res;
    }
}