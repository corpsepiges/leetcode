#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        return list(self.create(nums,[]))
    def create(self,nums,possibility):
        for num in nums:
            if num not in possibility:
                if len(possibility)==len(nums)-1:
                    yield [num]
                else :
                    for result in self.create(nums,possibility+[num]):
                        yield [num]+result
