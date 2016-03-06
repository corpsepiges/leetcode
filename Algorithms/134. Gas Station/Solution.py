#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        l=len(gas)
        remider=[gas[i]-cost[i] for i in range(l)]
        if sum(remider)<0:
            return -1
        ans=0
        flag=True
        while ans<l and flag:
            flag=False
            total=0
            for i in range(ans,ans+l):
                total+=remider[i%l]
                if total<0:
                    if ans>i%l+1:
                        return -1
                    ans=i%l+1
                    flag=True
                    break
        return ans%l