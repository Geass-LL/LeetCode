package Leet;

import java.util.*;

import DS.Interval;

/*
 * ����56���ɣ��������ӵ�Ԫ�ؼӽ�ȥ��Ȼ�������ںϡ�
 * ���õİ취��Q56_new,��OneNote 57.
 */
public class q57 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res=new ArrayList();
		intervals.add(newInterval);
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a,Interval b) {
				return a.start-b.start;
			}
		});
		Interval temp=intervals.get(0);
		if(intervals.size()==1) {
			res.add(temp);
			return res;
		}
		for(int i=1;i<intervals.size();i++) {
			if(intervals.get(i).start<=temp.end)
				temp.end=Math.max(temp.end,intervals.get(i).end);
			else {
				res.add(temp);
				temp=intervals.get(i);
			}
		}
		res.add(temp);
		return res;
    }
}
