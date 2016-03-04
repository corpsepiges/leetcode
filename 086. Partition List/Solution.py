#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        small=ListNode(0)
        sNode=small
        big=ListNode(0)
        bNode=big
        while head:
            if head.val<x:
                sNode.next=head
                sNode=sNode.next
            else:
                bNode.next=head
                bNode=bNode.next
            head=head.next
        bNode.next=None
        sNode.next=big.next
        return small.next