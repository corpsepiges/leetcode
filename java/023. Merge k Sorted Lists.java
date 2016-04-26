/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length>2) {
            ListNode[] l1=new ListNode[lists.length/2];
            ListNode[] l2=new ListNode[lists.length-lists.length/2];
            for (int i = 0; i < lists.length; i++) {
                if (i<lists.length/2) {
                    l1[i]=lists[i];
                }else {
                    l2[i-lists.length/2]=lists[i];
                }
            }
            return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));
        }else if (lists.length==2){
            return mergeTwoLists(lists[0],lists[1]);
        }else if (lists.length==1){
            return lists[0];
        }else {
            return null;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {  
        if (l1==null) {  
            return l2;  
        }  
        if (l2==null) {  
            return l1;  
        }  
        ListNode l=null;  
        if (l1.val>l2.val) {  
            l=new ListNode(l2.val);  
            l.next=mergeTwoLists(l1,l2.next);  
        }else {  
            l=new ListNode(l1.val);  
            l.next=mergeTwoLists(l1.next,l2);  
        }  
        return l;  
    }  
}