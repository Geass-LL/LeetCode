package Leet;

import java.util.Arrays;

/*
 * 以1 1 3 3 3 5 6为例：
 * 先将它转换成数组a（长度为citations长度+1），其中a[i]表示大于等于i的数字个数，那么上式可以转换为：
 * 7 7 5 5 2 2 1 0
 * 然后利用相等的数字看能不能拆得满足要求：
 * 对于i: >i的为>=i+1的，记为a,
 *       <i的为总数减去>=i的，记为c,
 *       =i的为>i的减去>=i的，记为b,
 *将b拆分为b1+b2，那么a+b1+b2+c=length
 *a+b1=i,b2+c=length-i
 *b1=i-a,b2=length-i-c
 *只要两者都大于0，说明是可行解。
 */

public class q274 {
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int[] counts=new int[citations.length+1];
		int prev=-1;
		for(int i=0;i<citations.length;i++) {
			if(citations[i]!=prev) {
				for(int j=prev+1;j<=Math.min(citations.length, citations[i]);j++) {
					counts[j]=citations.length-i;
				}
				prev=citations[i];
			}
		}
		for(int i=0;i<citations.length;i++) {
			int a=counts[i+1],b=counts[i]-counts[i+1],c=citations.length-counts[i];
			int b1=i-a,b2=citations.length-i-c;
			if(b1>=0&&b2>=0)	return i;
		}
		return citations.length;
    }
}
