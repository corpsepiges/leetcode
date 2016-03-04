/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head,int val) {
    	List<ListNode> list=zuhe(head, new ArrayList<ListNode>(),val);
    	if (list.size()==0) {
    		return null;
    	}
    	for (int i = 0; i < list.size()-1; i++) {
			list.get(i).next=list.get(i+1);
		}
    	list.get(list.size()-1).next=null;
    	return list.get(0);
    }

    public List<ListNode> zuhe(ListNode head,List<ListNode> list, int val){
    	if (head!=null) {
    		if (head.val!=val) {
    			list.add(head);
			}
			list=zuhe(head.next,list,val);
		}
    	return list;
    }
}