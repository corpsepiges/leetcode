#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        length=self.getLength(head)
        if not head or length==0 or k%length==0:
            return head
        else:
            k=k%length
        node=head
        while length-k>1:
            node=node.next
            length-=1
        end=self.getEndNode(head)
        end.next=head
        ans=node.next
        node.next=None
        return ans
    def getLength(self,head):
        ans=0
        while head:
            ans+=1
            head=head.next
        return ans
    def getEndNode(self,head):
        while head.next:
            head=head.next
        return head