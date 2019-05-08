package Leet;

import DS.ListNode;

/*
 * ��Ҫ˼·�����ÿ���ָ������е��ʱ��˳�㽫ǰ�����������ת������
 * fast==null����fast.next==null����������������������Ȼ���ż�����ȡ�
 */

public class q234 {
	public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow=head,fast=head.next,prev=null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            ListNode next=slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;
        }
        ListNode newhead=slow.next;//�������������Ȼ���ż�����ȣ����ε�ͷ���ֶ�����slow.next��ʼ�ġ�
        if(fast==null){//�������ȣ�slow���ˣ�slow��ǰ��ֵ���رȽ�
            slow=prev;
        }else if(fast.next==null){
            slow.next=prev;//ż�����ȣ���ǰslow��Ч������
        }
        while(slow!=null){
            if(slow.val!=newhead.val){
                return false;
            }else{
                slow=slow.next;
                newhead=newhead.next;
            }
        }
        return true;
    }
}
