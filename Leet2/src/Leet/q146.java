package Leet;

import java.util.*;

/*
 * 思路：
 * 考虑到O（1）的时间复杂度，肯定是用map来查找。
 * 这里map的值有为一个三元数组，第一个数为对应值，第二个数为前一个key，第三个数为后一个key。即后两个数建成一个双向链表的形式。
 * 前向指向上一个LRU的key，后向指向下一个LRU的key。最LRU的key的第三个数为0，最不LRU的key，也即马上要被淘汰的key，第二个数为0.
 * 每次get和Put时，注意维护好这个链表即可。
 */

public class q146 {
		public int start,end,size;
		public Map<Integer, int[]> map;
	    public q146(int capacity) {
	        map=new HashMap<Integer,int[]>();
	        start=0;
	        end=0;
	        size=capacity;
	    }
	    public int get(int key) {
	    	if(map.containsKey(key)) {
	    		update(key);
	    		return map.get(key)[0];
	    	}else {
	    		return -1;
	    	}
	    }
	    public void put(int key, int value) {
	        if(map.containsKey(key)) {
	        	update(key);
	        	map.get(key)[0]=value;
	        }else {
	        	if(map.size()==size) {
	        		int tempstart=map.get(start)[2];
	        		if(tempstart!=0) {
		        		map.remove(start);
		        		map.get(tempstart)[1]=0;
		        		start=tempstart;
		        		map.get(end)[2]=key;
		        		int[] temp= {value,end,0};
		        		map.put(key, temp);
		        		end=key;
	        		}else {
	        			map.remove(start);
	        			int[] temp= {value,0,0};
	        			map.put(key, temp);
	        			end=key;
	        			start=key;
	        		}
	        	}else {
	        		if(end==0) {
	        			int[] temp= {value,0,0};
	        			start=key;
	        			end=key;
	        			map.put(key, temp);
	        		}else {
	        			map.get(end)[2]=key;
	        			int[] temp= {value,end,0};
	        			map.put(key, temp);
	        			end=key;
	        		}
	        	}
	        }
	    }
	    public void update(int key) {
	    	if(key==start) {
	    		int tempstart=map.get(start)[2];
	    		if(tempstart!=0) {
	    			start=tempstart;
	    			map.get(start)[1]=0;
	    			map.get(key)[1]=end;
	    			map.get(key)[2]=0;
	    			map.get(end)[2]=key;
	    			end=key;
	    		}
	    	}else if(key!=end) {
	    		int mae=map.get(key)[1],usiro=map.get(key)[2];
	    		map.get(mae)[2]=usiro;
	    		map.get(usiro)[1]=mae;
	    		map.get(key)[1]=end;
	    		map.get(key)[2]=0;
	    		map.get(end)[2]=key;
	    		end=key;
	    	}
	    }
}
