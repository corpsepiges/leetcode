#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        ans=head
        while ans and ans.val==val:
            ans=ans.next
        if ans is not None:
            node=ans
            while node.next:
                if node.next.val == val:
                    node.next=node.next.next
                else:
                    node=node.next
        return ans