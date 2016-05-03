#coding=utf-8
import collections

__author__ = 'xuxuan'
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        map1={}
        map2={}
        for num in nums:
            map1[num]=map1.get(num,0)+1
        for key,value in map1.iteritems():
            map2[value]=map2.get(value,[])+[key]
        arrays=map2.keys()
        arrays.sort(reverse=True)
        ans=[]
        a=0
        while len(ans)<k:
            ans+=map2.get(arrays[a])
            a+=1
        return ans

    #这是一句话的方法
    def oneSentenceMethod(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        return [x[0] for x in collections.Counter(nums).most_common(k)]