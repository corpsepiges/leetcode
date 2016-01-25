#coding=utf-8
__author__ = 'xuxuan'
# Definition for binary tree with next pointer.
# class TreeLinkNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution(object):
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        if root is None or root.left is None:
            return
        root.left.next=root.right
        if root.next is not None:
            root.right.next=root.next.left
        self.connect(root.left)
        self.connect(root.right)