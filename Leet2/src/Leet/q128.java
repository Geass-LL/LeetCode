package Leet;

import java.util.*;

/*
 * ������һ��Hard��������⣬���Լ����ŵ��ˡ�
 * ��ʵ������HashTable����ģ�
 * 1����Hash���¼�Ը�ֵΪ����ĩβ����󳤶ȣ���ʼȫ��Ϊ1��
 * 2������ÿ������ִ�����²�����
 * 		��1�������ǰ������4����Ӧֵ��0��Ѱ�Ҽ���1����3���Ƿ�����ҷ�0������temp���ϼ�1������󳤶ȣ�������1����ֵ�޸�Ϊ0��
 * ����ӦֵΪ0�ĺ��弴��������Ѿ���������ˣ�
 */

public class q128 {
	public int longestConsecutive(int[] nums) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int res=0;
		for(int eachnum:nums) {
			map.put(eachnum, 1);
		}
		for(int eachkey:map.keySet()) {
			if(map.get(eachkey)!=0) {
				int searchkey=eachkey-1;
				int temp=map.get(eachkey);
				while(map.containsKey(searchkey)&&map.get(searchkey)!=0) {
					temp+=map.get(searchkey);
					map.put(searchkey,0);
					searchkey--;
				}
				map.put(eachkey, temp);
				if(temp>res) {
					res=temp;
				}
			}
		}
		return res;
    }
}
