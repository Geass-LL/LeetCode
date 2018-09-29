package Leet;

import java.util.*;

public class q17 {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList();
        String[] bango= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i=0;i<digits.length();i++) {
        	int num=Integer.valueOf(digits.charAt(i)-48);
        	res=this.combine(res, bango[num]);
        }
        return res;
    }
	List<String> combine(List<String> a,String b){
		List<String> combineres=new ArrayList();
		if(a.size()==0) {
			for (int i=0;i<b.length();i++) {
				combineres.add(b.substring(i, i+1));
			}
		}
		for(String eachString:a) {
			for (int i=0;i<b.length();i++) {
				String temp=eachString+b.charAt(i);
				combineres.add(temp);
			}
		}
		return combineres;
	}
}
