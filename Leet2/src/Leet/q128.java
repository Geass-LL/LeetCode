package Leet;

import java.util.*;

/*
 * 看到是一个Hard级别的问题，把自己给吓到了。
 * 其实可以用HashTable解决的：
 * 1、用Hash表记录以该值为序列末尾的最大长度，初始全部为1；
 * 2、对于每个键，执行如下操作：
 * 		（1）如果当前键（如4）对应值非0，寻找键减1（即3）是否存在且非0，是则temp加上减1键的最大长度，并将减1键的值修改为0；
 * 键对应值为0的含义即：这个键已经被处理过了；
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
