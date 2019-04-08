/*���������������ϲ�Ϊһ���µ��������������ء���������ͨ��ƴ�Ӹ������������������нڵ���ɵġ�
ʾ����
���룺1->2->4, 1->3->4
�����1->1->2->3->4->4*/

package LinkList;

public class mergeTwoLists 
{
	public class ListNode 
	{
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public static ListNode merge(ListNode l1, ListNode l2)
	{
		mergeTwoLists mt = new mergeTwoLists();
		ListNode res = mt.new ListNode(-1);
		ListNode p, q, r;
		p = l1;
		q = l2;
		r = res;
		while (p != null && q != null)
		{
			if (p.val <= q.val)
			{
				r.next = p;
				p = p.next;
				r = r.next;
			}
			else
			{
				r.next = q;
				q = q.next;
				r = r.next;
			}
		}
		if (p != null)
			r.next = p;
		if (q != null)
			r.next = q;
		res = res.next;
		return res;
	}

}