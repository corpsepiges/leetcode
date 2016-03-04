#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if not head:
            return None
        node=head
        map={}
        while node:
            newNode=RandomListNode(node.label)
            map[node]=newNode
            node=node.next
        node=head
        while node:
            newNode=map[node]
            newNode.next=map.get(node.next)
            newNode.random=map.get(node.random)
            node=node.next
        return map.get(head)