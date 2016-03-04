/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
    	ListNode fast=head;
    	ListNode slow=head;
        while (true) {
			if (fast==null||fast.next==null) {
				return null;
			}
			fast=fast.next.next;
			slow=slow.next;
			if (fast==slow) {
				ListNode again=head;
				while (true) {
					if (slow==again) {
						return again;
					}else {
						slow=slow.next;
						again=again.next;
					}
				}
			}
		}
    }
}