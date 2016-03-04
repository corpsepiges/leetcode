#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ans=[]
        nums.sort()
        for i in range(0,len(nums)-2,1):
            if(i>0 and nums[i]==nums[i-1]):
                continue
            s=i+1
            e=len(nums)-1
            while(s<e):
                if((nums[i]+nums[s]+nums[e])==0):
                    a=[nums[i],nums[s],nums[e]]
                    ans.append(a)
                    flag=False
                    for j in range(s+1,e,1):
                        if(nums[j]!=nums[s]):
                            s=j
                            flag=True
                            break
                    if(not flag):
                        break
                    flag=False
                    for j in range(e-1,s,-1):
                        if(nums[j]!=nums[e]):
                            e=j
                            flag=True
                            break
                    if(not flag):
                        break
                elif(nums[i]+nums[s]+nums[e]>0):
                    flag=False
                    for j in range(e-1,s,-1):
                        if(nums[j]!=nums[e]):
                            e=j
                            flag=True
                            break
                    if(not flag):
                        break
                else:
                    flag=False
                    for j in range(s+1,e,1):
                        if(nums[j]!=nums[s]):
                            s=j
                            flag=True
                            break
                    if(not flag):
                        break
        return ans


nums=[-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0]
print Solution().threeSum(nums)
