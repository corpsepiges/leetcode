#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def twoSum(self, nums, target):
        map={}
        for i in range(nums.__len__()):
            map[(target-nums[i])]=i
        for i in range(nums.__len__()):
            if(map.get(nums[i])):
                ans=[]
                ans.append(i+1)
                ans.append(map.get(nums[i])+1)
                return ans
