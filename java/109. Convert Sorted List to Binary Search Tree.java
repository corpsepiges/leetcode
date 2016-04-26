/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return f(head,null);
    }
    public TreeNode f(ListNode head,ListNode end) {
        if (head==end) {
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=end&&fast.next.next!=end) {
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode node=new TreeNode(slow.val);
        node.right=f(slow.next,end);
        node.left=f(head,slow);
        return node;
    }
}