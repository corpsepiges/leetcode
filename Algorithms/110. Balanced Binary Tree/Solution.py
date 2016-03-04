#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return True if root is None else abs(self.maxDeep(root.left)-self.maxDeep(root.right))<=1 and self.isBalanced(root.left) and self.isBalanced(root.right)

    def maxDeep(self,root):
        return 0 if root is None else max(self.maxDeep(root.left),self.maxDeep(root.right))+1