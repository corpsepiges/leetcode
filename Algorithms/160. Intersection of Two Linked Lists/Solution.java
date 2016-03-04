/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a=Count(headA, 0);
        int b=Count(headB, 0);
        return compare(headA, a, headB, b);
    }
    public ListNode compare(ListNode headA,int a, ListNode headB,int b) {
			if (a>b) {
				return compare(headA.next, a-1, headB, b);
			}else if (a<b) {
				return compare(headA, a, headB.next, b-1);
			}else {
				if (headA==headB) {
					return headA;
				}else {
					return compare(headA.next, a-1, headB.next, b-1);
				}
			}
    }
    public int Count(ListNode head,int i){
    	if (head!=null) {
			i++;
			i=Count(head.next,i);
		}
    	return i;
    }
}