#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        l=len(nums)
        if l==0:
            return []
        ans=[]
        arrays=[]
        for i in range(l-1,-1,-1):
            a=self.findIndex(nums[i],arrays)
            ans.append(a)
            arrays[a:a]=[nums[i]]
        ans.reverse()
        return ans
    def findIndex(self,num,arrays):
        if len(arrays)==0 or num<=arrays[0]:
            return 0
        s=0
        e=len(arrays)-1
        while s+1<e:
            m=(s+e)/2
            if arrays[m]>=num:
                e=m
            else:
                s=m
        if arrays[s]>=num:
            return s
        if arrays[e]>=num:
            return e
        return e+1