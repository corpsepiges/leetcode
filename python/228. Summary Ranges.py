#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        ans=[]
        if len(nums)==0:
            return ans
        for i in range(len(nums)):
            if nums[i]-i!=nums[0]:
                res=str(nums[0]) if i<=1 else str(nums[0])+'->'+str(nums[i-1])
                ans.append(res)
                other=self.summaryRanges(nums[i:])
                if len(other)!=0:
                    ans+=other
                return ans
        ans.append(str(nums[0]) if len(nums)==1 else str(nums[0])+'->'+str(nums[-1]))
        return ans