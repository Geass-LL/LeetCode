package Leet;
import java.util.*;

//类似AAAAAAAAAAA这样的也算做有AAAAAAAAAA的重复。采用位操作及哈希表。

public class q187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res=new ArrayList<String>();
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<s.length()-9;i++) {
        	char[] temp=s.substring(i, i+10).toCharArray();
        	int tempint=0;
        	for(int j=0;j<10;j++) {
        		if(temp[j]=='A') tempint=(tempint<<2);
        		else if(temp[j]=='C') tempint=(tempint<<2)+1;
        		else if(temp[j]=='G') tempint=(tempint<<2)+2;
        		else tempint=(tempint<<2)+3;
        	}
        	if(map.containsKey(tempint)&&map.get(tempint)==0) {
        		res.add(s.substring(i,i+10));
        		map.put(tempint, 1);
        	}
        	if(!map.containsKey(tempint)) map.put(tempint, 0);
        }
        return res;
    }
}
