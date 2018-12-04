package Leet;

import java.util.*;

/*
 * ˼·��
 * ���ǵ�O��1����ʱ�临�Ӷȣ��϶�����map�����ҡ�
 * ����map��ֵ��Ϊһ����Ԫ���飬��һ����Ϊ��Ӧֵ���ڶ�����Ϊǰһ��key����������Ϊ��һ��key����������������һ��˫���������ʽ��
 * ǰ��ָ����һ��LRU��key������ָ����һ��LRU��key����LRU��key�ĵ�������Ϊ0���LRU��key��Ҳ������Ҫ����̭��key���ڶ�����Ϊ0.
 * ÿ��get��Putʱ��ע��ά������������ɡ�
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
