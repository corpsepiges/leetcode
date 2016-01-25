#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        return list(self.f(root,''))
    def f(self,root,state):
        if root is not None:
            param='->'+str(root.val) if len(state)!=0 else str(root.val)
            for result in self.f(root.left,state+param):
                yield param+result
            for result in self.f(root.right,state+param):
                yield param+result
            if root.left is None and root.right is None:
                yield param