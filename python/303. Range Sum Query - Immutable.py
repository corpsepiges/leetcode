#coding=utf-8
__author__ = 'xuxuan'
class NumArray(object):
    _board=[]
    def __init__(self, nums):
        """
        initialize your data structure here.
        :type nums: List[int]
        """
        self._board=[0]
        for i in range(1,len(nums)+1):
            self._board.append(self._board[i-1]+nums[i-1])
    def sumRange(self, i, j):
        """
        sum of elements nums[i..j], inclusive.
        :type i: int
        :type j: int
        :rtype: int
        """
        return self._board[j+1]-self._board[i]