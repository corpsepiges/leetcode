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
        if root is None or (root.left is None and root.right is None):
            return
        node=root.next
        next=None
        while node and not next:
            next=node.left if node.left else node.right
            node=node.next
        if root.right is not None:
            root.right.next=next
            if root.left is not None:
                root.left.next=root.right
        else:
            root.left.next=next
        self.connect(root.right)
        self.connect(root.left)

