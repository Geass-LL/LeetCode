package Leet;

import java.util.*;

import DS.Interval;

/*
 * 二分，二分，二分法尼玛逼。。。
 * 就不能简简单单地直接循环过去吗？多么朴实！
 * 方法见OneNote
 */
public class q56_new {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        boolean flag=true;
        for(Interval cur:intervals) {
        	if(cur.start>newInterval.start) {
        		res.add(newInterval);
        		newInterval=cur;//这句很重要！点睛之笔。
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
