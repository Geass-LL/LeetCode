package Leet;

import DS.ListNode;
/*
 * ��������ת��k��Ԫ�صķ�ת��
 */
public class q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
    	//�ų��������
    	if (biggerthan(head,k)) {
    		//���η�תk������Ԫ�أ�����������ͷ
        	head=reverse(head,k);
        	return head;
    	}else {
    		return head;
    	}
    }
    ListNode reverse(ListNode head,int k) {
    	ListNode tail=head;//���������β��������תǰ��ͷ��
    	ListNode prev=null;
    	ListNode now=head;
    	ListNode next=null;
    	int deep=0;
    	while(now!=null && deep<k) {
    		//����תNNNPPNNN
    		next=now.next;
    		now.next=prev;
    		prev=now;
    		now=next;
    		deep++;
    	}
    	//�����ֻ��Ҫ��ʼ��һ��
    	final ListNode res=prev;
    	//�������ĳ��Ȼ��Ǻܳ�����ô������ת������һ�б��β��ָ���������ͷ
    	if(biggerthan(next,k)) {
    		tail.next=reverse(next,k);
    	}else {
    		//����������ˣ���ô���ط�ת��ֱ��β���ӵ���һ��ͷ��
    		tail.next=next;
    	}
    	return res;
    }
    //�жϴ���ת�������Ƿ�����趨ֵ
    boolean biggerthan(ListNode head,int k) {
    	int length=0;
    	while(head!=null) {
    		length++;
    		if(length>=k) {
    			return true;
    		}
    		head=head.next;
    	}
    	return false;
    }
}
