#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        return list(self.f(root,[],sum))

    def f(self,root,state,sum):
        if root:
            if root.left or root.right:
                for result in self.f(root.left,state+[root.val],sum-root.val):
                    yield [root.val]+result
                for result in self.f(root.right,state+[root.val],sum-root.val):
                    yield [root.val]+result
            elif sum==root.val:
                yield [root.val]
