package Leet;

import java.util.*;

/*
 * ���аɣ���Ҫ�����������ĶԳ��ԣ�
 */
public class q89 {
	public List<Integer> grayCode(int n) {
		List<Integer> res=new ArrayList<Integer>();
		if(n==0) {
			res.add(0);
			return res;
		}
		res.add(0);
		res.add(1);
		for(int i=1;i<n;i++) {
			int sizenow=res.size();
			for(int j=0;j<sizenow;j++) {
				res.add(sizenow+res.get(sizenow-1-j));
			}
		}
		return res;
    }
}
