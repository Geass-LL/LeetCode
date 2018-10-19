package Leet;

import java.util.*;

import DS.Interval;

/*
 * ���֣����֣����ַ�����ơ�����
 * �Ͳ��ܼ�򵥵���ֱ��ѭ����ȥ�𣿶�ô��ʵ��
 * ������OneNote
 */
public class q56_new {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        boolean flag=true;
        for(Interval cur:intervals) {
        	if(cur.start>newInterval.start) {
        		res.add(newInterval);
        		newInterval=cur;//������Ҫ���㾦֮�ʡ�
        	}else if(cur.end<newInterval.start) {
        		res.add(cur);
        	}else {
        		newInterval.end=Math.max(cur.end, newInterval.end);
        		newInterval.start=Math.min(cur.start, newInterval.start);
        	}
        }
        if(flag)
        	res.add(newInterval);
        return res;
    }
}
