package Leet;

import DS.ListNode;
/*
 * �ȿ������ܹ��ж೤���ڴ�Ӧ�ý�ȡ�ĵط��س�������ǰ��Ľ��ϡ�
 */
public class q61 {
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null) {
			return null;
		}
		int length=1;
		ListNode temp=head;
        while(temp.next!=null) {
        	length++;
        	temp=temp.next;
        }
        if(k%length==0)//����ʱ
        	return head;
        else {
        	int rostep=length-k%length;
        	int cur=0;
        	temp=head;
        	while(cur<rostep-1) {//ע���Ǽ�1����һ��Ԫ��Ϊ�µ�ͷ��
        		temp=temp.next;
        		cur++;
        	}
        	ListNode reshead=temp.next;//�µ�ͷ��
        	temp.next=null;//�µ�β��
        	temp=reshead;
        	while(temp.next!=null) {
        		temp=temp.next;
        	}
        	temp.next=head;//��ԭ����β�ͽ���ԭ����ͷ
        	return reshead;//�����µ�ͷ��
        }
    }
}
