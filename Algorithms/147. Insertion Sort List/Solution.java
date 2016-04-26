/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }
        ListNode node=head.next;
        ListNode ans=new ListNode(head.val);
        while (node!=null) {
            if (node.val<=ans.val) {
                ListNode newAns=new ListNode(node.val);
                newAns.next=ans;
                ans=newAns;
            }else {
                ListNode test=ans;
                ListNode a=null;
                while (test!=null&&test.val<node.val) {
                    a=test;
                    test=test.next;
                }
                ListNode insert=new ListNode(node.val);
                a.next=insert;
                insert.next=test;
            }
            node=node.next;
        }
        return ans;
    }
}