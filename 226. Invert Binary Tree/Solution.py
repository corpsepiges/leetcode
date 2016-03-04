#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root is not None:
            node=root.left
            root.left=self.invertTree(root.right)
            root.right=self.invertTree(node)
            return root
        else:
            return None