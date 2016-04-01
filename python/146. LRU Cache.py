#coding=utf-8
__author__ = 'xuxuan'
class LRUCache(object):
    _list={}
    _value={}
    _length=0
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self._list=[]
        self._value={}
        self._length=capacity


    def get(self, key):
        """
        :rtype: int
        """
        ans=self._value.get(key)
        if ans is not None:
            self.set(key,ans)
            return ans
        return -1


    def set(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: nothing
        """

        if not self._value.get(key):
            if len(self._list)==self._length:
                del self._value[self._list[0]]
                self._list[0:1]=[]
        else:
            self._list.remove(key)
        self._list.append(key)
        self._value[key]=value