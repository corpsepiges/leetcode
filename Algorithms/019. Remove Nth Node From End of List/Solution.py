#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        array=[]
        while head:
            array.append(head)
            head=head.next
        if n==1:
            if len(array)==1:
                return None
            else:
                array[-2].next=None
        else:
            array[-n].val=array[-n].next.val
            array[-n].next=array[-n].next.next
        return array[0]