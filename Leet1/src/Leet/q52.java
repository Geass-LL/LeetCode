package Leet;

import java.util.*;
/*
 * 额，解都出来了，把解的大小返回不就行了？
 */

public class q52 {
	public int totalNQueens(int n) {
        List<List<String>> res=new ArrayList();
        btk(res,0,new ArrayList(),n);
        return res.size();
    }
	void btk(List<List<String>> res,int deep,List<String> tempres,int n) {
		if(deep==n) {
			res.add(new ArrayList(tempres));
		}else {
			deep++;
			List<String> cho=cacucho(tempres,n);
			if(cho.size()>0) {
				for(String eachcho:cho) {
					tempres.add(eachcho);
					btk(res,deep,tempres,n);
					tempres.remove(tempres.size()-1);
				}
			}
		}
	}
	public List<String> cacucho(List<String> indata,int inn){
		int[] pos=new int[indata.size()];
		int[] res=new int[inn];
		char[] reschar=new char[inn];
		List<String> trueres=new ArrayList();
		for(int i=0;i<inn;i++) {
			reschar[i]='.';
		}
		for(int i=0;i<indata.size();i++) {
			for(int j=0;j<indata.get(i).length();j++) {
				if(indata.get(i).charAt(j)=='Q') {
					pos[i]=j;
					break;
				}
			}
		}
		for(int i=0;i<pos.length;i++) {
			res[pos[i]]=1;
			int temp=indata.size()-i;
			if(pos[i]-temp>=0) res[pos[i]-temp]=1;
			if(pos[i]+temp<inn) res[pos[i]+temp]=1;
		}
		for(int i=0;i<inn;i++) {
			if(res[i]==0) {
				reschar[i]='Q';
				trueres.add(new String(reschar));
				reschar[i]='.';
			}
		}
		return trueres;
	}
}
