#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        l=len(nums)
        if l==0:
            return None
        ans=TreeNode(nums[l/2])
        ans.left=self.sortedArrayToBST(nums[0:l/2])
        ans.right=self.sortedArrayToBST(nums[l/2+1:l])
        return ans