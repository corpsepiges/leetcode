#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        else :
            ans=head.next
            head.next=self.swapPairs(ans.next)
            ans.next=head
            return ans