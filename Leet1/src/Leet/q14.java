package Leet;

public class q14 {
	public String longestCommonPrefix(String[] strs) {
        String res="";
        String temp="";
        int alli=0;
        if (strs.length==0) {
        	return res;
        }else if(strs.length==1){
        	return strs[0];
        }else {
	        while(alli>=0) {
	        	if(alli<strs[0].length()) {
	        		temp=strs[0].substring(alli, alli+1);
	        	}else {
	        		return res;
	        	}
	        	for (int i=1;i<strs.length;i++) {
	        		if (alli<strs[i].length()) {
		        		String strtemp=strs[i].substring(alli, alli+1);
		        		if(!strtemp.equals(temp)) {
		        			return res;
		        		}
	        		}else {
	        			return res;
	        		}
	        	}
	        	alli++;
	        	res+=temp;
	        }
	        return res;
        }
    }
}