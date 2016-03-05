#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    _map={}
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return 0
        self._map={0:0,1:nums[-1]}
        return self.f(nums)
    def f(self,nums):
        n=len(nums)
        if self._map.get(n) is None:
            self._map[n]=max(nums[0]+self.f(nums[2:]),nums[1]+self.f(nums[3:]))
        return self._map[n]
