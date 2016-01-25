#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        return self.f(root)[k-1]
    def f(self,root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        return [] if root is None else self.f(root.left)+[root.val]+self.f(root.right)
