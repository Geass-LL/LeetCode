package Leet;

import java.util.HashMap;
import java.util.Map;
/*
 * �Ƚ�Map�����ö�˵��
 * �ٽ�һ�����飬��˳���ţ�
 * ��������num,�����������дӴ�С���αȽϣ�������ڻ��ߵ��ڣ����λ����ȷ��������num��ǰֵ�����С�ڣ���������С�����ƶ���
 * ԭ�����ô�����ʾ�������ô�����ʾ��ֱ���޷��ô�����ʾ���ƶ�cur��
 * �ٸ�����----------
 *30��������40����ʾ��cur�´�ѭ���Ƶ�10���ж�30>=10����ʱ���������ƶ�cur��
 */
public class q12 {
    public String intToRoman(int num) {
        Map map=new HashMap();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
        int[] dicts= {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String res="";
        int index=dicts.length-1;
        while (num!=0) {
        	int cur=dicts[index];
        	if(num>=cur) {
        		res+=map.get(cur);
        		num-=cur;
        	}else {
        		index--;
        	}
        }
        return res;
    }
}
