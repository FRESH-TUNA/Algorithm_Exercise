from heapq import heappush, heappop, heapify
import sys
class Beakjoon_1753_solver:
    array = []
    min = []
    num_of_vertax = None
    num_of_edges = None
    start = None

    @classmethod
    def init(clr):
        clr.num_of_vertax, clr.num_of_edges = list(map(int, input().split()))
        clr.visited = (clr.num_of_vertax + 1) * [False]
        clr.start = int(input())
        clr.minHeap = [[sys.maxsize, x] for x in range(clr.num_of_vertax + 1)] 
        clr.minHeap[clr.start][1] = 0
        clr.min = [sys.maxsize] * (clr.num_of_vertax + 1)
        clr.min[clr.start] = 0
        
    @classmethod
    def service(clr):
        visitedCount = 1
        start = clr.start

        while clr.minHeap:
            heapMin = heappop(clr.minHeap)
            if heapMin[0] <= clr.min[heapMin[1]]:
                for x in range(vertex):
                    if clr.min[heapMin[1]] > clr.min[x] + array[x][heapMin[1]]:
                        clr.min[heapMin[1]] = clr.min[x] + array[x][heapMin[1]]



        while visitedCount < len(clr.visited):
            for edge in clr.array:
                if edge[1] == start:
                    if clr.min[edge[1]] + edge[0] < clr.min[edge[2]]:
                        clr.min[edge[2]] = clr.min[edge[1]] + edge[0]
                        if clr.visited[edge[2]] is False:
                            heappush(clr.minHeap, [clr.min[edge[1]] + edge[0], edge[2]])

            clr.visited[start] = True
            visitedCount += 1
            tempNext = None

            if len(clr.minHeap) is 0:
                break
            else:
                tempNext = heappop(clr.minHeap)
                start = tempNext[1]

        for x in range(1, len(clr.min)):
            if clr.min[x] is sys.maxsize:
                print('INF')
            else:
                print(clr.min[x])



if __name__ == "__main__":
    Beakjoon_1753_solver.init()
    Beakjoon_1753_solver.service()
    