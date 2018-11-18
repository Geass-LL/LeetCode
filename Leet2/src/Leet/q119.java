package Leet;

import java.util.*;

public class q119 {
	public List<Integer> getRow(int rowIndex) {
        int i=0;
        List<Integer> res=new ArrayList<Integer>();
        res.add(1);
        while(i<rowIndex) {
        	int j=1, temp1,temp2;
        	temp1=res.get(0);
        	while(j<=i) {
        		temp2=res.get(j);
        		res.set(j++, temp1+temp2);
        		temp1=temp2;
        	}
        	res.add(1);
        	i++;
        }
        return res;
    }
}
