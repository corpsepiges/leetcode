#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return True if root is None or self.f(root.left,root.right) else False
    def f(self,left,right):
        if left is None or right is None:
            return left is right
        return left.val==right.val and self.f(left.left,right.right) and self.f(left.right,right.left)
