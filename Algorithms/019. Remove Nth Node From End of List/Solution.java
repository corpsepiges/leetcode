/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list=new ArrayList<ListNode>();
        list=addlist(head, list);
        if (list.size()==n) {
            return head.next;
        }
        list.get(list.size()-n-1).next=n==1?null:list.get(list.size()-n+1);
        return head;
    }
    public  List<ListNode> addlist(ListNode head, List<ListNode> list){
        if (head!=null) {
            list.add(head);
        }else {
            return list;
        }
        return addlist(head.next, list);
    }
}