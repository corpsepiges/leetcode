/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head!=null) {
            List<ListNode> list = zuhe(head, new ArrayList<ListNode>());
            int l=list.size();
            for (int i = 0; i < l/2; i++) {
                list.get(i).next = list.get(l - 1 - i);
                list.get(l - 1 - i).next = list.get(i + 1);
            }
            list.get(l/2).next = null;
        }
    }
    public List<ListNode> zuhe(ListNode head, List<ListNode> list) {
        while (head!=null) {
            list.add(head);
            head=head.next;
        }
        return list;
    }
}