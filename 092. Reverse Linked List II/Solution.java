/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	List<ListNode> list=f(head, new ArrayList<ListNode>());
    	list.get(m-1).next=list.get(n-1).next;
    	for (int i = n-1; i >=m; i--) {
			list.get(i).next=list.get(i-1);
		}
    	if (m!=1) {
			list.get(m-2).next=list.get(n-1);
			return list.get(0);
		}else {
			return list.get(n-1);
		}
    }
    public List<ListNode> f(ListNode head,List<ListNode> list){
    	if (head!=null) {
			list.add(head);
			list=f(head.next,list);
		}
    	return list;
    }
}