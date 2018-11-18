package Leet;

import java.util.*;

public class q118 {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(numRows<=0) return res;
        List<Integer> temp=new ArrayList<Integer>();
        temp.add(1);
        res.add(temp);
        int i=1;
        while(i<numRows) {
        	List<Integer> newtemp=new ArrayList<Integer>();
        	newtemp.add(1);
        	int j=1;
        	while(j<res.get(i-1).size()) {
        		newtemp.add(res.get(i-1).get(j)+res.get(i-1).get(j-1));
        		j++;
        	}
        	newtemp.add(1);
        	res.add(newtemp);
        	i++;
        }
        return res;
    }
}
