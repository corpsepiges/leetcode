/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }else {
            int val=head.val;
            head.val=head.next.val;
            head.next.val=val;
            head.next.next=swapPairs(head.next.next);
        }
        return head;
    }
}