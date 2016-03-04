#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        product=1
        zeroNum=0;
        zeroIndex=-1;
        for i in range(len(nums)):
            if nums[i]==0:
                zeroNum+=1
                zeroIndex=i
                if zeroNum>1:
                    break
            else :
                product*=nums[i]
        ans=[0]*len(nums)
        if zeroNum==0:
            for i in range(len(nums)):
                ans[i]=product/nums[i]
        elif zeroNum==1:
            ans[zeroIndex]=product
        return ans