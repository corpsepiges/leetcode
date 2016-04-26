/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        ListNode node=head;
        ListNode oddStart=odd;
        ListNode evenStart=even;
        head=head.next.next;
        int i=1;
        while (head!=null) {
            if (i%2==0) {
                even.next=head;
                even=even.next;
            }else {
                odd.next=head;
                odd=odd.next;
            }
            head=head.next;
            i++;
        }
        even.next=null;
        odd.next=evenStart;
        return oddStart;
    }
}