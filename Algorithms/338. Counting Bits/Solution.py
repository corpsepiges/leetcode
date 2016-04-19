#coding=utf-8
__author__ = 'xuxuan'
import math
class Solution(object):
    _nums=[0]
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        if num<len(self._nums):
            return self._nums[:num+1]
        for i in range(len(self._nums),num+1):
            self._nums.append(self._nums[i-int(math.pow(2,int(math.log(i,2))))]+1)
        return self._nums