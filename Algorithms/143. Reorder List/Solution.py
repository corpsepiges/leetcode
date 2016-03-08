#coding=utf-8
__author__ = 'xuxuan'
# Definition for a undirected graph node
class UndirectedGraphNode(object):
    def __init__(self, x):
        self.label = x
        self.neighbors = []

class Solution(object):
    _map={}
    _finish={}
    def cloneGraph(self, node):
        """
        :type node: UndirectedGraphNode
        :rtype: UndirectedGraphNode
        """
        self.f(node)
        keys=self._map.keys()
        for node in keys:
            a=self._map[node]
            for nei in node.neighbors:
                a.neighbors.append(self._map[nei])
        return self._map[node]
    def f(self,node):
        if node and self._map.get(node) is None:
            self._map[node]=UndirectedGraphNode(node.val)
            for nei in node.neighbors:
                self.f(nei)
