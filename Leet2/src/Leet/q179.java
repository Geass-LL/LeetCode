package Leet;

/*
 * �����㷨��������õ���ð�����򣬵�����Ҫ���¶����С�Ƚϣ�
 *  1��������compare�����Ƚ�a��b�Ĵ�С�����a<b������true��
 */

public class q179 {
	public String largestNumber(int[] nums) {
        for(int i=0;i<nums.length;i++) {
        	for(int j=0;j<nums.length;j++) {
        		if(!compare(nums[i],nums[j])) {
        			int temp=nums[i];
        			nums[i]=nums[j];
        			nums[j]=temp;
        		}
        	}
        }
        String res="";
        for(int i=0;i<nums.length;i++) {
        	res+=String.valueOf(nums[i]);
        }
        if(res.substring(0, 1).equals("0")) res="0";//�����ͷ���㣬˵������Ķ����㣬��������£�ֻ����һ���㼴�ɣ�
        return	res;
    }
	public boolean compare(int a,int b) {
		if(a==b) return false;
		boolean change=false;
		if(a>b) {
			int temp=a;
			a=b;
			b=temp;
			change=true;
		}
		boolean res=true;
		char[] chara=String.valueOf(a).toCharArray();
		char[] charb=String.valueOf(b).toCharArray();
		int i=0;
		while(i<chara.length) {
			//ת����char�������ұȽ�ÿһλ��
			if(chara[i]>charb[i]) {
				res=false;
				break;
			}else if(chara[i]<charb[i]) {
				res=true;
				break;
			}else {
				i++;
			}
		}
		if(i==chara.length) {
			//���ǰ��ļ�λ��һ�£�ִ���������������ٸ����Ӽ���
			//a=343,b=3433,tempb=3343.
			//ab=343|3433|
			//ba=343|3343|
			//���ʵ�ʱȽϵ���3343��3433�Ĵ�С��
			//�и��������������a��tempb��ȣ���
			//a=3,b=30,tempb=3
			//Ӧ�õó��Ľ����a<b������b��tempb���Ƚϡ�
			int tempb=Integer.valueOf(String.valueOf(b).substring(i)+String.valueOf(b).substring(0, i));
			if(a==tempb) {
				res=false;
			}else {
				if(b<tempb) res=true;
				else res=false;
			}
		}
		if(change) return !res;
		else return res;
	}
}
