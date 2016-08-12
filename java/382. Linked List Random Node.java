/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode node;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        node=head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode ans=node;
        int val=ans.val;
        Random r=new Random();
        for (int i = 1; ans!=null; i++) {
            if (r.nextInt(i)==0) {
                val=ans.val;
            }
            ans=ans.next;
        }
        return val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */