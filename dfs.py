class Graph:
    def __init__(self, numOfNodes=None, adjMatrix=None):
        self.numOfNodes = numOfNodes
        self.adjMatrix = adjMatrix
        
    def initGraph(self):
        numOfNodes = self.numOfNodes
        adjMatrix = [[] for _ in range(numOfNodes)]
        vertex, weight = 0, 0
        numOfEdges = int(input())

        for _ in range(numOfEdges):
            vertex, weight = input().split()
            adjMatrix[int(vertex)].append([int(vertex),int(weight)])
        self.adjMatrix = adjMatrix



a = Graph(5)
a.initGraph()
print(a.adjMatrix)

