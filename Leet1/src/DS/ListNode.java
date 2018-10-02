package DS;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }
	public void Show() {
		ListNode cur=this;
		String strres="";
		while(cur!=null) {
			strres+=String.valueOf(cur.val);
			strres+="->";
			cur=cur.next;
		}
		System.out.println(strres.substring(0, strres.length()-2));
	}
}
