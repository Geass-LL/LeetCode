package Leet;

import java.util.*;

public class q68 {
	
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> temp=new ArrayList<String>();
        List<String> res=new ArrayList<String>();
        int templength=0;
        for(String word:words) {
        	if(templength==0)
        		templength=word.length();
        	else
        		templength+=word.length()+1;
        	if(templength<=maxWidth) {
        		temp.add(word);
        	}else {
        		res.add(all(temp,maxWidth));
        		temp.clear();
        		templength=word.length();
        		temp.add(word);
        	}
        }
        if(temp.size()>0) {
        	String laststr="";
        	int laststrlength=0;
        	for(String eachtemp:temp) {
        		laststr+=eachtemp+" ";
        		laststrlength+=eachtemp.length()+1;
        	}
        	laststr=laststr.substring(0,laststr.length()-1);
        	laststrlength-=1;
        	for(int i=0;i<maxWidth-laststrlength;i++)
        		laststr+=" ";
        	res.add(laststr);
        }
        return res;
    }
	String all(List<String> words,int maxWidth) {
		int gapnum=words.size()-1;
		int alllength=0;
		for(String word:words) {
			alllength+=word.length();
		}
		int gaplength=maxWidth-alllength;
		String blank="";
		if(gapnum==0) {
			for(int i=0;i<gaplength;i++)
				blank+=" ";
			return words.get(0)+blank;
		}
		int quo=gaplength/gapnum,rem=gaplength%gapnum;
		for(int i=0;i<quo;i++)
			blank+=" ";
		String res="";
		for(int i=0;i<gapnum;i++) {
			res+=words.get(i)+blank;
			if(i<rem)
				res+=" ";
		}
		return res+words.get(gapnum);
	}
}
