package Leet;

import DS.ListNode;
/*
 * �½���һ�����������
 * 1���������ظ������֣������ֵ��һ����
 * 2����β�������ظ������֣������ֵ��һ��������������
 * ���������������ԭʼ������������ͬʱ��ʱ�����½�������
 * ����������ܰ�ԭʼ����ĵ�һ��ֵ�������Ƿ����ظ����������Ϊ����ͷ��
 * ���ǽ����жϣ����ظ���ʱ��ѡ������ͷ��next���ء�
 */
public class q82 {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null)
			return null;
		ListNode res=head;
		ListNode trueres=res;
		boolean flag=false;
		if(head.next!=null&&head.next.val==head.val) {
			flag=true;//���ظ���ʱ��ѡ������ͷ��next���ء�
		}
		while(head.next!=null) {
			if(head.next.val!=head.val) {
				head=head.next;
				if(head.next!=null&&head.next.val!=head.val) {//�������ظ�������
					res.next=new ListNode(head.val);
					res=res.next;
				}else if(head.next==null) {//��β�������ظ�������
					res.next=new ListNode(head.val);
					res=res.next;
					res.next=null;
				}
			}else {
				head=head.next;
				res.next=null;
			}
		}
		if(flag)
			return trueres.next;//���ظ���ʱ��ѡ������ͷ��next���ء�
		else
			return trueres;
    }
}
