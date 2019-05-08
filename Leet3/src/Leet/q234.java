package Leet;

import DS.ListNode;

/*
 * 主要思路：在用快慢指针查找中点的时候，顺便将前面的链表做反转操作。
 * fast==null还是fast.next==null决定了这个链表是奇数长度还是偶数长度。
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
        ListNode newhead=slow.next;//无论是奇数长度还是偶数长度，后半段的头部分都是以slow.next开始的。
        if(fast==null){//奇数长度，slow回退，slow当前的值不必比较
            slow=prev;
        }else if(fast.next==null){
            slow.next=prev;//偶数长度，当前slow有效，链回
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
