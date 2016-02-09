/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode answer=null;
    	if (head!=null) {
			answer=new RandomListNode(head.label);
		}else {
			return null;
		}
    	if (head.random!=null) {
    		answer.random=new RandomListNode(head.random.label);
		}
    	answer.next=copyRandomList(head.next);
    	return answer;
    }
}