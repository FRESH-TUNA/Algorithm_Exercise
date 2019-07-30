import sys

class Beakjoon_1463_solver:
    result_array = {'1': 0}

    @classmethod
    def solve(self, current_number):
        if current_number == 1:
            return 0
        else:
            min_count = sys.maxsize
            temp = None

            if current_number % 3 == 0:
                if Beakjoon_1463_solver.result_array.get(str(current_number // 3), False):
                    min_count = 1 + Beakjoon_1463_solver.result_array[str(current_number // 3)]
                else:
                    min_count = 1 + self.solve(current_number // 3)

            if current_number % 2 == 0:
                if Beakjoon_1463_solver.result_array.get(str(current_number // 2), False):
                    temp = 1 + Beakjoon_1463_solver.result_array[str(current_number // 2)]
                else:
                    temp = 1 + self.solve(current_number // 2)
                if temp < min_count:
                    min_count = temp

            if Beakjoon_1463_solver.result_array.get(str(current_number - 1), False):
                temp = 1 + Beakjoon_1463_solver.result_array[str(current_number - 1)]
            else:
                temp = 1 + self.solve(current_number - 1)

            if temp < min_count:
                min_count = temp
            
            Beakjoon_1463_solver.result_array[str(current_number)] = min_count
            return min_count
            
                
if __name__ == "__main__":
    sys.setrecursionlimit(1000000)
    print(Beakjoon_1463_solver.solve(int(input())))
