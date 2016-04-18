#coding=utf-8
__author__ = 'xuxuan'
# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class NestedIterator(object):
    _ans=[]
    _index=0
    _length=0
    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self._ans=self.flat(nestedList)
        self._index=0
        self._length=len(self._ans)

    def next(self):
        """
        :rtype: int
        """
        a=self._ans[self._index] if self._index<self._length else None
        self._index+=1
        return a

    def hasNext(self):
        """
        :rtype: bool
        """
        return self._index<self._length

    def flat(self, nestedList):
        """
        :type nestedList: List[NestedInteger]
        :rtype: List<Integer>
        """
        ans=[]
        for nestedInteger in nestedList:
            ans+=([nestedInteger.getInteger()] if nestedInteger.isInteger() else self.flat(nestedInteger.getList()))
        return ans

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())