package Leet;

import java.util.*;

/*
 * ���̰���㷨��ֱͦ�۵ġ�
 */

public class q455 {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int gi=0,si=0;
		int res=0;
		while(gi<g.length&&si<s.length) {
			if(g[gi]<=s[si]) {
				gi++;
				si++;
				res++;
			}else {
				si++;
			}
		}
		return res;
    }
}
