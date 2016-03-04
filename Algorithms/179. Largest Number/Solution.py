#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def largestNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        ans=''
        while len(nums)>0:
            max=self.finMax(nums)
            ans+=str(max)
            nums.remove(max)
        return str(int(ans))
    def compaer(self,n1,n2):
        s1=str(n1)+str(n2)
        s2=str(n2)+str(n1)
        for i in range(len(s1)):
            if s1[i]>s2[i]:
                return True
            if s1[i]<s2[i]:
                return False
        return False
    def finMax(self,nums):
        if len(nums)==1:
            return nums[0]
        max=nums[0]
        for num in nums:
            if self.compaer(num,max):
                max=num
        return max