/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null) {
			return true;
		}
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
        ListNode test=f(slow);
        while (test!=null) {
			if (test.val!=head.val) {
				return false;
			}
			test=test.next;
			head=head.next;
		}
        
        return true;
    }
    //原地翻转链表
    public ListNode f(ListNode node){
    	if (node==null||node.next==null) {
			return node;
		}
    	ListNode l=node.next;
    	ListNode h;
    	node.next=null;
    	while (l!=null) {
			h=l.next;
			l.next=node;
			node=l;
			l=h;
		}
    	return node;
    }
}