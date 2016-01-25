#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        return self.f(None,head)

    def f(self,before,now):
        if now is None:
            return None
        next=now.next
        now.next=before
        if next is None:
            return now
        else:
            return self.f(now,next)
