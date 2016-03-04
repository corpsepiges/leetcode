#coding=utf-8
__author__ = 'xuxuan'
# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        if len(intervals)==0:
            return [newInterval]
        ns=newInterval.start
        ne=newInterval.end
        start=-1
        end=-1
        for i in range(len(intervals)):
            if start==-1:
                e=intervals[i].end
                if e>=ns:
                    start=i
            s=intervals[i].start
            if s<=ne:
                end=i
            else:
                break
        if start==-1:
            return intervals+[newInterval]
        if end==-1:
            return [newInterval]+intervals
        ansStart=intervals[start].start if intervals[start].start<newInterval.start else newInterval.start
        ansEnd=intervals[end].end if intervals[end].end>newInterval.end else newInterval.end
        intervals[start:end+1]=[Interval(ansStart,ansEnd)]
        return intervals