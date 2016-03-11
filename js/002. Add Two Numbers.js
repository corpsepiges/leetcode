/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    return add(l1,l2,false)
};
var add =function(l1,l2,flag) {
	if (l1===null) {
		if(flag){
			return add(new ListNode(1),l2,false)
		}
		return l2
	}
    if(l2===null){
    	if(flag){
			return add(l1,new ListNode(1),false)
		}
		return l1
    }
    var v=l1.val+l2.val+(flag?1:0);
    var ans=new ListNode(v%10);
    ans.next=add(l1.next,l2.next,v>=10);
    return ans;
};