package Leet;

import DS.ListNode;

/*
 * �ÿ���ָ���ҵ��е㣬���е�����sec2���ַ�ת��Ȼ��ǰ���������������ӡ�
 */

public class q143 {
	public void reorderList(ListNode head) {
		if(head==null||head.next==null) return;
		ListNode sp=head,fp=head.next;
		while(fp!=null&&fp.next!=null) {
			fp=fp.next.next;
			sp=sp.next;
		}
		ListNode sec2=null,now=sp.next,next;//��now��ʼΪ��벿�֣��ȼ�¼����Ϊsp.next��Ȼ���sp.next��null���ϸ�����ǰ��
		sp.next=null;
		while(now!=null) {//��ת
			next=now.next;
			now.next=sec2;
			sec2=now;
			now=next;
		}
		while(head!=null&&sec2!=null) {//������ӣ�ע�����ֶ����ȿ��Ǻ����һ����һ����
			next=sec2.next;
			sec2.next=head.next;
			head.next=sec2;
			head=sec2.next;
			sec2=next;
		}
    }
}
