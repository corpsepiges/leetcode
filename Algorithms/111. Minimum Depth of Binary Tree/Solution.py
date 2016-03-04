#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        if not(root.left or root.right):
            return 1
        if root.left and root.right:
            return 1+min(self.minDepth(root.left),self.minDepth(root.right))
        return 1+(self.minDepth(root.left) if root.left else self.minDepth(root.right))