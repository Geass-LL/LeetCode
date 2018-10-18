package Leet;

import java.util.*;

import DS.Interval;
/*
 * 这个题学习一个怎么对自定义类型排序。
 * Collections.sort()怎么实现的很重要，可以说,java的基础还不过关。
 * 排序成功以后，其他的就是easy难度了。
 */
public class q56 {
	public List<Interval> merge(List<Interval> intervals) 
    {
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0)  return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Interval temp = intervals.get(0);
        if(intervals.size() == 1) {
            res.add(temp);
            return res;
        }
        for(int i=1; i<intervals.size(); i++) {
            if(temp.end >= intervals.get(i).start) {
                temp.end = Math.max(temp.end, intervals.get(i).end);
            }else{
                res.add(temp);
                temp = intervals.get(i);
            }
        }
        res.add(temp);
        return res;
    }	
}
