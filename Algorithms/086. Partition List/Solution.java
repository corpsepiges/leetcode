/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
    	List<ListNode> littleList=zuheL(head,new ArrayList<ListNode>(),x);
    	List<ListNode> bigList=zuheB(head,new ArrayList<ListNode>(),x);
    	int ll=littleList.size();
    	int lb=bigList.size();
    	if (ll==0||lb==0) {
    		return head;
		}
    	for (int i = 0; i < ll-1; i++) {
    		littleList.get(i).next=littleList.get(i+1);
		}
    	littleList.get(ll-1).next=bigList.get(0);
    	for (int i = 0; i < lb-1; i++) {
    		bigList.get(i).next=bigList.get(i+1);
		}
    	bigList.get(lb-1).next=null;
    	return littleList.get(0);
    }
    public List<ListNode> zuheL(ListNode head,List<ListNode> list,int x){
    	if (head!=null) {
    		if (head.val<x) {
    			list.add(head);
			}
			list=zuheL(head.next,list,x);
		}
    	return list;
    }
    public List<ListNode> zuheB(ListNode head,List<ListNode> list,int x){
    	if (head!=null) {
    		if (head.val>=x) {
    			list.add(head);
			}
			list=zuheB(head.next,list,x);
		}
    	return list;
    }
}