package Leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * ����39Ӧ���Ǽ��˸о���������ά��firstsum�ˡ�
 * ���ȵ��Ÿ���
 * �ֳ��������⣺
 * a,a,b,c,d,...
 * 1����a��ʱ�򣬰�a������ȥ�������Ϊtarget-a�����п��ܽ⣻
 * 2��û��a��ʱ��������ͬ��aֱ�ӵ�b������b,c,d,...ֵΪtarget�����п��ܽ⡣
 */
public class q40 {
	public List<List<Integer>> combination2Sum(int[] candidates, int target) {
		Arrays.sort(candidates);
    	List<List<Integer>> res=dyp(candidates,0,candidates.length,target);
    	return res;
    }
    List<List<Integer>> dyp(int[] candidates,int from,int to,int target){
    	//��ֹ����
    	if(from>=to) {
    		return null;
    	}
    	List<List<Integer>> res=new ArrayList<List<Integer>>();//���ս��
    	int curnum=candidates[from];
    	int nextfrom=from;//��������һ������ת���ɴ����￪ʼ��С���⡣
    	while(nextfrom<to&&candidates[nextfrom]==curnum) {
    		nextfrom++;
    	}
    	from++;//��һ������
    	if(curnum<target) {
    		List<List<Integer>> tempres1=dyp(candidates,from,candidates.length,target-curnum);
    		if(tempres1!=null) {//�ǿ�
	    		for(List<Integer> eachlist:tempres1) {
	    			eachlist.add(curnum);//�ѵ�һ������ֵ�������ⲿ�ֺϲ�
	    			res.add(eachlist);//��Ϊ���ս����һ�����н�
	    		}
    		}
    	}else if(curnum==target){//��Ҫ����������������������������������Ҫ
    		List<Integer> curres=new ArrayList();
    		curres.add(curnum);
    		res.add(curres);//����һ���������Ŀ��н�
    	}
    	List<List<Integer>> tempres2=dyp(candidates,nextfrom,candidates.length,target);//�ڶ���������
    	if(tempres2!=null)//�ǿ�
    		res.addAll(tempres2);
    	return res;
    }
}
