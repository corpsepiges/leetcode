#coding=utf-8
__author__ = 'xuxuan'
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        l=len(lists)
        if l==0:
            return None
        if l==1:
            return lists[0]
        left=self.mergeKLists(lists[:l/2])
        right=self.mergeKLists(lists[l/2:])
        ans=ListNode(0)
        node=ans
        while left or right:
            node.next=left if not right or (left and left.val<right.val) else right
            node=node.next
            left=node.next if left is node else left
            right=node.next if right is node else right
        return ans.next