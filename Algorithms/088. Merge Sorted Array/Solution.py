#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        sm=0
        sn=0
        while sn!=n:
            if sm==m:
                nums1[sm:]=nums2[sn:n]
                sn=n
            else:
                if nums1[sm]>nums2[sn]:
                    nums1[sm+1:m+1]=nums1[sm:m]
                    nums1[sm]=nums2[sn]
                    m+=1
                    sn+=1
                sm+=1