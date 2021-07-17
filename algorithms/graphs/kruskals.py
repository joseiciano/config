"""
Idea for Kruskal's:
    1. Sort all edges in non-decreasing order
    2. Choose the smallest edge and check if it will
        make a cycle.
        If a cycle would be made, ignore it.
        If a cycle would not be made, add it to result
    3. Repeat until (v-1) edges in the tree
"""


from typing import List, Tuple


class kruskals:
    def __init__(self, vertices: int):
        self.vertices: int = vertices
        self.edgelist: List[Tuple[int, int, int]] = []

    def addEdge(self, u: int, v: int, w: int) -> None:
        # Vertex u goes to v with cost w
        self.edgelist.append([u, v, w])

    def find(self, parent: List[int], i: int) -> int:
        # Finds the set of element i
        if parent[i] == i:
            return i
        return self.find(parent, parent[i])

    def union(self, parent: List[int], rank: List[int], x: int, y: int) -> None:
        # Union by rank groups x and y
        xroot: int = self.find(parent, x)
        yroot: int = self.find(parent, y)

        # Smaller rank goes under higher rank
        if rank[xroot] < rank[yroot]:
            parent[xroot] = yroot
        elif rank[xroot] > rank[yroot]:
            parent[yroot] = xroot
        else:
            parent[yroot] = xroot
            rank[xroot] += 1

    def mst(self) -> None:
        ret: List[Tuple[int, int, int]] = []

        i: int = 0  # Pointer to initial
        j: int = 0  # Pointer to result

        self.edgelist = sorted(self.edgelist, key=lambda item: item[2])

        parent: List[int] = []
        rank: List[int] = []

        for node in range(self.vertices):
            parent.append(node)
            rank.append(0)

        while j < self.vertices - 1:
            # Pick the smallest edge
            u, v, w = self.edgelist[i]
            i += 1
            x = self.find(parent, u)
            y = self.find(parent, v)

            # If no cycle, include this edge
            # Otherwise, ignore it
            if x != y:
                j += 1
                ret.append([u, v, w])
                self.union(parent, rank, x, y)

        print(ret)


# g = kruskals(4)
# g.addEdge(0, 1, 10)
# g.addEdge(0, 2, 6)
# g.addEdge(0, 3, 5)
# g.addEdge(1, 3, 15)
# g.addEdge(2, 3, 4)

# # Function call
# g.mst()
