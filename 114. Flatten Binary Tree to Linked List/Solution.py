#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        if root is None:
            return None
        self.flatten(root.left)
        self.flatten(root.right)
        left=root.left
        right=root.right
        node=left
        while node and node.right:
            node=node.right
        root.left=None
        if left:
            root.right=left
            node.right=right
        else:
            root.right=right