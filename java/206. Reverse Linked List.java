/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null) {
			return head;
		}
    	List<ListNode> list=zuhe(head, new ArrayList<ListNode>());
        for (int i = list.size()-1; i >0; i--) {
			list.get(i).next=list.get(i-1);
		}
        list.get(0).next=null;
        return list.get(list.size()-1);
    }
    
    public List<ListNode> zuhe(ListNode head,List<ListNode> list){
    	if (head!=null) {
			list.add(head);
			list=zuhe(head.next,list);
		}
    	return list;
    }
}