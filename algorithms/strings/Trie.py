class TriNode:
    def __init__(self):
        self.children = {}
        self.words = set()

class Trie:
    def __init__(self):
        self.root = TriNode()

    def insert(self, word):
        cur = self.root

        for c in word:
            if c not in cur.children:
                cur.children[c] = TriNode()
            cur = cur.children[c]
        
        cur.words.add(word)

    def search(self, word):
        cur = self.root

        for c in word:
            if c not in cur.children:
                return False
            cur = cur.children[c]
        
        return word in cur.words
