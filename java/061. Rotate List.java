/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) {
            return head;
        }
        ListNode l=head;
        List<ListNode> list=new ArrayList<ListNode>();
        while (l!=null) {
            list.add(l);
            l=l.next;
        }
        k=k%list.size();
        if (k==0) {
            return head;
        }
        list.get(list.size()-k-1).next=null;
        list.get(list.size()-1).next=head;
        return list.get(list.size()-k);
    }
}