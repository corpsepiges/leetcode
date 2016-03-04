/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	head=findFirst(head);
    	if (head!=null) {
			head.next=deleteDuplicates(head.next);
		}
        return head;
    }
    public ListNode findFirst(ListNode head) {
    	if (head==null||head.next==null||head.val!=head.next.val) {
    		return head;
		}
    	int i=head.val;
    	while (head!=null) {
			if (head.val!=i) {
				return findFirst(head);
			}
			head=head.next;
		}
    	return null;
    }
}