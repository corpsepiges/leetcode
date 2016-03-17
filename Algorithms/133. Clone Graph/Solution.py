#coding=utf-8
__author__ = 'xuxuan'
# Definition for a undirected graph node
class UndirectedGraphNode(object):
    def __init__(self, x):
        self.label = x
        self.neighbors = []

class Solution(object):
    _map={}
    def cloneGraph(self, node):
        """
        :type node: UndirectedGraphNode
        :rtype: UndirectedGraphNode
        """
        self._map={}
        if node:
            self.f(node)
            keys=self._map.keys()
            for key in keys:
                a=self._map[key]
                for nei in key.neighbors:
                    a.neighbors.append(self._map[nei])
            return self._map[node]
        return None
    def f(self,node):
        if node and not self._map.get(node) :
            self._map[node]=UndirectedGraphNode(node.label)
            for nei in node.neighbors:
                self.f(nei)