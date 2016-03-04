#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        one=ListNode(0)
        ans1=one
        two=ListNode(0)
        ans2=two
        i=0
        while head:
           if i%2==0:
               one.next=head
               one=one.next
           else:
               two.next=head
               two=two.next
           head=head.next
           i+=1
        two.next=None
        one.next=ans2.next
        return ans1.next

