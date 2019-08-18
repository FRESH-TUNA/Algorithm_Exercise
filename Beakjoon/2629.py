import sys

class Beakjoon_2629_solver():
    num_of_chu = None
    chus = [] 
    num_of_question = None
    questions = []
    result = []

    @classmethod
    def init(clr):
        clr.num_of_chu = int(sys.stdin.readline())
        clr.chus = list(map(int, sys.stdin.readline().split()))
        clr.num_of_question = int(sys.stdin.readline())
        clr.questions = list(map(int, sys.stdin.readline().split()))
        clr.result = ['Y'] * clr.num_of_question

    @classmethod
    def backtrack(clr, left=0, right=0, chu_index=0, question):
        if chu_index is not clr.num_of_chu - 1
            left += clr.num_of_chu[chu_index]
            if left < right and left+question is right:
                return True
            elif left > right and right+question is left:
                return True
            else:
                clr.backtrack(left, right, chu_index + 1, question)

            right += clr.num_of_chu[chu_index]
            if left < right:

            elif left > right:

            else: 
        else:
            return False

if __name__ == "__main__":
    Beakjoon_1753_solver.init()
    Beakjoon_1753_solver.dijkstra()
    Beakjoon_1753_solver.print()
    