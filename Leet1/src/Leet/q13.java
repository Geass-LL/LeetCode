package Leet;

import java.util.HashMap;
import java.util.Map;
/*
 * ˼·����Map����ʽ�洢��
 * ���ǵ�����IX������ǰ��С�����1λ��һֱ��sum��¼��һλ��num��
 * ������num>sumʱ����XIV������֣�res��֮ǰ�Ѿ�������һ�ǵ�num����ǰ��sum������£���ȥ����sum�ټ��ϵ�ǰ��num����֮�����sum
 * ��Ϊnum<sumʱ����XI���������ֱ�Ӽ��ϵ�ǰ��num���ɣ�����res��
 * Ч������98.77%
 */
public class q13 {
	public int romanToInt(String s) {
        Map map=new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int num=0;
        int res=0;
        int sum=0;
        for (int i=0;i<s.length();i++) {
        	num=(int)map.get(s.charAt(i));
        	if (num>sum) {
        		res=res+num-2*sum;
        		sum=num;
        	}else {
        		sum=num;
    			res+=num;
        	}
        }
        return res;
    }
}
