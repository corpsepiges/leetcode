#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head
        val=head.val
        if head.next and head.next.val==val:
            while head and head.val==val:
                head=head.next
            return self.deleteDuplicates(head)
        head.next=self.deleteDuplicates(head.next)
        return head