package Leet;

import java.util.HashMap;
import java.util.Map;
/*
 * 先建Map，不用多说；
 * 再建一个数组，按顺序存放；
 * 输入数字num,把它和数组中从大到小依次比较，如果大于或者等于，则该位得以确定，更新num当前值；如果小于，则数组向小方向移动；
 * 原则：能用大数表示，则尽量用大数表示，直到无法用大数表示，移动cur。
 * 举个例子----------
 *30：不能用40来表示，cur下次循环移到10，判断30>=10成立时，并不会移动cur。
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
