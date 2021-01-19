class unionfind:
    def __init__(self, n):
        self.size = n # Number of nodes
        self.sz = [1 for i in range(n)] # Size of each components
        self.id = [i for i in range(n)] # Parent of i, parent[i] = i means root
        self.numComponents = n
    
    def find(self, p):
        # Finds the root of node p, which shows its component
        root = p
        while root != self.id[root]:
            root = self.id[root]

        # Path compression
        while self.id[p] != root:
            nextNode = self.id[p]
            self.id[p] = root
            p = nextNode
    
        return root

    def connected(self, p, q):
        # Check if p and q are connected (in the same component)
        return self.find(p) == self.find(q)
    
    def componentSize(self, p):
        return self.sz[self.find(p)]

    def unify(self, p, q):
        root1 = self.find(p)
        root2 = self.find(q)

        # Elements are already in the same component
        if root1 == root2:
            return

        if self.sz[root1] < self.sz[root2]:
            self.sz[root2] += self.sz[root1]
            self.id[root1] = root2
        else:
            self.sz[root1] += self.sz[root2]
            self.id[root2] = root1
        
        # Got rid of one component
        self.numComponents -= 1