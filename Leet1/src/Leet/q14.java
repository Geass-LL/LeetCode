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
	        	temp=strs[0].substring(alli, alli+1);
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