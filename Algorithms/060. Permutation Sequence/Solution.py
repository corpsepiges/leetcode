#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        nums=range(1,n+1)
        pro=1
        ans=""
        k-=1
        for num in nums:
            pro*=num
        while len(nums)>0:
            pro/=len(nums)
            i=k/(pro)
            ans+=str(nums[i])
            nums[i:i+1]=[]
            k-=i*pro
        return ans