package Leet;

import java.util.Arrays;

/*
 * ��1 1 3 3 3 5 6Ϊ����
 * �Ƚ���ת��������a������Ϊcitations����+1��������a[i]��ʾ���ڵ���i�����ָ�������ô��ʽ����ת��Ϊ��
 * 7 7 5 5 2 2 1 0
 * Ȼ��������ȵ����ֿ��ܲ��ܲ������Ҫ��
 * ����i: >i��Ϊ>=i+1�ģ���Ϊa,
 *       <i��Ϊ������ȥ>=i�ģ���Ϊc,
 *       =i��Ϊ>i�ļ�ȥ>=i�ģ���Ϊb,
 *��b���Ϊb1+b2����ôa+b1+b2+c=length
 *a+b1=i,b2+c=length-i
 *b1=i-a,b2=length-i-c
 *ֻҪ���߶�����0��˵���ǿ��н⡣
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
