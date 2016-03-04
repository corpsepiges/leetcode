#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if headA is None or headB is None:
            return None;
        end=headA
        while end.next is not None:
            end=end.next
        #将headA的尾部和headB的头部相连，则问题等价于环图求环点（142	Linked List Cycle II）
        end.next=headB
        fast=headA
        slow=headA
        while fast is not None and fast.next is not None:
            fast=fast.next.next
            slow=slow.next
            if slow==fast:
                fast=headA
                while fast is not slow:
                    fast=fast.next
                    slow=slow.next
                end.next=None
                return fast
        end.next=None
        return None