package Leet;

import DS.UndirectedGraphNode;
import java.util.*;

/*
 * �ö��а�node��û�м���map�е��ھӴ���������������״���ֵ�������ѭ������
 * ÿ���ھӽ��е�����
 */

public class q133 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null) return null;
		Map<Integer, UndirectedGraphNode> map=new HashMap<Integer,UndirectedGraphNode>();
		Queue<UndirectedGraphNode> ori=new LinkedList<UndirectedGraphNode>();
		ori.add(node);
		UndirectedGraphNode res=new UndirectedGraphNode(node.label);
		map.put(node.label, res);
		while(!ori.isEmpty()) {
			UndirectedGraphNode temp=ori.poll();
			for(UndirectedGraphNode eachnode:temp.neighbors) {
				if(!map.containsKey(eachnode.label)) {
					map.put(eachnode.label, new UndirectedGraphNode(eachnode.label));
					ori.add(eachnode);
				}
				map.get(temp.label).neighbors.add(map.get(eachnode.label));
			}
		}
		return res;
    }
}
