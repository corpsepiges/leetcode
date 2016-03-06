#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head and head.next:
            fast=head.next
            slow=head
            while fast and fast.next:
                fast=fast.next.next
                slow=slow.next
            node2=self.sortList(slow.next)
            slow.next=None
            node1=self.sortList(head)
            ans=ListNode(0)
            node=ans
            while node1 and node2:
                if node1.val<node2.val:
                    node.next=node1
                    node1=node1.next
                else:
                    node.next=node2
                    node2=node2.next
                node=node.next
            node.next=node1 if node1 else node2
            return ans.next
        return head