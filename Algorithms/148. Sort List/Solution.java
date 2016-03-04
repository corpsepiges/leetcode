/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
    	if (head==null||head.next==null) {
			return head;
		}
        ListNode mid=getMid(head);
        ListNode next=mid.next;
        mid.next=null;
    	return merge(sortList(head),sortList(next));
    }
    public ListNode getMid(ListNode head){
    	ListNode fast=head;
    	ListNode slow=head;
    	while(fast.next!=null&&fast.next.next!=null) {  
            slow = slow.next;  
            fast = fast.next.next;  
        }  
    	return slow;
    }
    public ListNode merge(ListNode a,ListNode b){
    	ListNode ans=new ListNode(0);
    	ListNode node=ans;
    	while (a!=null&&b!=null) {
    		if (a.val<b.val) {
				node.next=a;
				a=a.next;
			}else {
				node.next=b;
				b=b.next;
			}
    		node=node.next;
		}
    	node.next=a==null?b:a;
    	return ans.next;
    }
}