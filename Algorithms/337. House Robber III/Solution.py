#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    _map={}
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        if self._map.get(root) is None:
            self._map[root]=max(root.val+(self.robSon(root.left)+self.robSon(root.right)),self.robSon(root))
        return self._map[root]

    def robSon(self,root):
        return self.rob(root.left)+self.rob(root.right) if root else 0
