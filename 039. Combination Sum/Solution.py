#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        return list(self.createAnswer(candidates,target,[]))
    def createAnswer(self,candidates, target,state):
        for num in candidates:
            if len(state)==0 or num>=state[-1]:
                if num==target:
                    yield [num]
                elif num<target:
                    for result in self.createAnswer(candidates,target-num,state+[num]):
                        yield [num]+result