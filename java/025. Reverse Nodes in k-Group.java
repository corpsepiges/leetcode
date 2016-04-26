/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l = head;
        List<Integer> val = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (l == null) {
                return head;
            }
            val.add(l.val);
            l = l.next;
        }
        l = head;
        for (int i = val.size() - 1; i >= 0; i--) {
            l.val = val.get(i);
            l = l.next;
        }
        l = reverseKGroup(l, k);
        return head;
    }
}/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l = head;
        List<Integer> val = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (l == null) {
                return head;
            }
            val.add(l.val);
            l = l.next;
        }
        l = head;
        for (int i = val.size() - 1; i >= 0; i--) {
            l.val = val.get(i);
            l = l.next;
        }
        l = reverseKGroup(l, k);
        return head;
    }
}