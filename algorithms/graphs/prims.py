"""
Idea for Prim's
1. Create a min heap of size v. 
        Every element in heap is (vertex number, key)
2. Initialize min heap with first vertex as root
    The key to all other vertices is oo
3. While min heap is not empty:
    Extract min value, u.
    For every adjacent vertex v, check if v is in heap.
        If v is in and its value is more than weight of u->v,
            update the value of v as weight of u->v.
"""
from collections import defaultdict
import heapq
from typing import DefaultDict, List, Tuple


class prims:
    def __init__(self, vertices):
        self.vertices: int = vertices
        self.graph: DefaultDict[any,
                                List[Tuple[int, int, int]]
                                ] = defaultdict(list)

    def addEdge(self, u: int, v: int, w: int) -> None:
        self.graph[u].append((w, u, v))
        self.graph[v].append((w, v, u))

    def mst(self) -> None:
        heap: List[Tuple[int, int, int]] = []
        edgeCount: int = 0
        mstCost: int = 0
        vis: List[bool] = [False for i in range(self.vertices)]
        mstEdges: List[Tuple[int, int, int]] = [
            None for i in range(self.vertices-1)]

        def addEdges(u):
            vis[u] = True
            for edge in self.graph[u]:
                if not vis[edge[2]]:
                    heapq.heappush(heap, edge)

        addEdges(0)

        while heap and edgeCount != self.vertices-1:
            edge = heapq.heappop(heap)
            w, u, v = edge

            if vis[v]:
                continue

            mstEdges[edgeCount] = edge
            edgeCount += 1
            mstCost += w

            addEdges(v)
        print(mstCost)

        for w, u, v in mstEdges:
            print(f"{u}->{v}: {w}")


graph = prims(9)
graph.addEdge(0, 1, 4)
graph.addEdge(0, 7, 8)
graph.addEdge(1, 2, 8)
graph.addEdge(1, 7, 11)
graph.addEdge(2, 3, 7)
graph.addEdge(2, 8, 2)
graph.addEdge(2, 5, 4)
graph.addEdge(3, 4, 9)
graph.addEdge(3, 5, 14)
graph.addEdge(4, 5, 10)
graph.addEdge(5, 6, 2)
graph.addEdge(6, 7, 1)
graph.addEdge(6, 8, 6)
graph.addEdge(7, 8, 7)
graph.mst()
