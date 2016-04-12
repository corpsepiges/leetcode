#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        middle=self.findKthLargest(nums,(n+1)/2)
        newIndex=[0]*n
        for i in range(n):
            newIndex[i]=(1+2*i)%(n|1)
        i=left=0
        right=n-1
        temp=0
        while i<=right:
            test=nums[newIndex[i]]
            if test>middle:
                self.swapTwoNumber(nums,newIndex[left],newIndex[i])
                left+=1
                i+=1
            elif test<middle:
                self.swapTwoNumber(nums,newIndex[right],newIndex[i])
                right-=1
            else:
                i+=1

    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pivot = nums[len(nums)/2]
        left=[]
        right=[]
        for i in range(len(nums)):
            if nums[i]>pivot:
                right.append(nums[i])
            if nums[i]<pivot:
                left.append(nums[i])
        if len(right)>=k:
            return self.findKthLargest(right,k)
        if k>len(nums)-len(left):
            return self.findKthLargest(left,k-len(nums)+len(left))
        return pivot

    def swapTwoNumber(self,nums,i,j):
        temp=nums[i]
        nums[i]=nums[j]
        nums[j]=temp