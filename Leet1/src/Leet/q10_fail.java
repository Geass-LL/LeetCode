package Leet;

import java.util.HashMap;
import java.util.Map;
/*
 * 一次失败的尝试;
 * 本来想用填坑的办法，用q做一堆坑，带*的坑无限深，如果s能把所有的坑填完就可以了；
 * 问题在于类似a*aa，这种，不知道怎么挖坑了。。。
 */
public class q10_fail {
	public boolean isMatch(String s, String p) {
		String box="";
		int length=p.length();
		int slength=s.length();
		int[] boxtype=new int[length];
		int boxtypeIndex=0;
		for (int i=0;i<length;i++) {
			char cur=p.charAt(i);
			if (cur!='*') {
				box+=cur;
				boxtype[boxtypeIndex]=0;
				boxtypeIndex++;
			}else {
				boxtype[boxtypeIndex-1]=1;
			}
		}
		System.out.println(box);
		for (int j=0;j<boxtypeIndex;j++) {
			System.out.println(boxtype[j]);
		}
		int boxi=0;
		int reslen=0;
		for (int i=0;i<slength;i++) {
			char cur=s.charAt(i);
			while(boxi<boxtypeIndex) {
				if(cur==box.charAt(boxi)||box.charAt(boxi)=='.') {
					reslen++;
					if (boxtype[boxi]==0) {
						boxtype[boxi]=2;
						boxi++;
					}
					break;
				}else {
					if(boxtype[boxi]==1) {
						boxtype[boxi]=2;
						boxi++;
					}else {
						return false;
					}
				}
			}
		}
		System.out.println("------------------------------");
		System.out.println(reslen);
		if (reslen!=slength) {
			return false;
		}
		for (int j=length-1;j>=0;j--) {
			if (boxtype[j]==0) {
				return false;
			}
		}
		return true;
    }
}
