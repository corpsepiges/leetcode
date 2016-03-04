#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums)<3:
            return False
        arrays=[]
        for num in nums:
            l=len(arrays)
            if l==0:
                arrays.append(num)
            elif l==1:
                if num>arrays[0]:
                    arrays.append(num)
                else:
                    arrays=[num]
            elif l==2:
                if num!=arrays[0] and num!=arrays[1]:
                    if num>arrays[0] and num>arrays[1]:
                        arrays.append(num)
                    elif num>arrays[0] and num<arrays[1]:
                        arrays=[arrays[0],num]
                    elif num<arrays[0] and num>arrays[1]:
                        arrays=[arrays[1],num]
                    else:
                        arrays=[arrays[1],num]
            else:
                return True
        return len(arrays)==3