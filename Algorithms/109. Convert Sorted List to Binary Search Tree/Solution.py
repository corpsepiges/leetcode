#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        if head is None:
            return None
        fast=head.next
        slow=head
        end=None
        while fast and fast.next :
            fast=fast.next.next
            end=slow
            slow=slow.next
        ans=TreeNode(slow.val)
        ans.right=self.sortedListToBST(slow.next)
        if end:
            end.next=None
            ans.left=self.sortedListToBST(head)
        return ans