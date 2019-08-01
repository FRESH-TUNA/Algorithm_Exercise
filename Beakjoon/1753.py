import queue
import sys

class Beakjoon_1753_solver():
    num_of_vertex = None
    num_of_edges = None
    start = None
    adj = [[]]
    result = []

    @classmethod
    def init(clr):
        clr.num_of_vertex, clr.num_of_edges = map(int, sys.stdin.readline().split())
        clr.start = int(sys.stdin.readline())
        clr.adj = [[] for i in range(clr.num_of_vertex + 1)]
        clr.result = [sys.maxsize] * (clr.num_of_vertex + 1) 

        while clr.num_of_edges:
            clr.num_of_edges -= 1
            start, end, weight = map(int, sys.stdin.readline().split())
            clr.adj[start].append((end, weight))


    @classmethod
    def dijkstra(clr):
        pq = queue.PriorityQueue()
        pq.put((0, clr.start))
        clr.result[clr.start] = 0

        while not pq.empty():
            distance, destination = pq.get()

            if clr.result[destination] < distance:
                continue
            
            for i in clr.adj[destination]:
                cost = distance + i[1]
                if clr.result[i[0]] > cost:
                    clr.result[i[0]] = cost
                    pq.put((cost, i[0]))

    @classmethod
    def print(clr):
        for i in range (1,clr.num_of_vertex + 1):
            if clr.result[i] is sys.maxsize:
                print("INF")
            else:
                print(clr.result[i])

if __name__ == "__main__":
    Beakjoon_1753_solver.init()
    Beakjoon_1753_solver.dijkstra()
    Beakjoon_1753_solver.print()
    
    