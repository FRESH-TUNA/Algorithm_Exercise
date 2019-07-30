import sys

class Beakjoon_1463_solver:
    result_array = [None] * 1000001

    @classmethod
    def solve(self, current_number):
        result_array = self.result_array
        result_array[0], result_array[1], result_array[2], result_array[3] = (0, 0, 1, 1)
        min_count = sys.maxsize

        for i in range(current_number + 1):
            if result_array[i] is None:
                if i % 3 == 0:
                    min_count = result_array[i // 3]
                    # print(min_count)

                if i % 2 == 0:
                    if result_array[i % 2] < min_count:
                        min_count = result_array[i // 2]
                        # print(min_count)

                if result_array[i - 1] < min_count:
                    min_count = result_array[i - 1]
                
                result_array[i] = min_count + 1
                min_count = sys.maxsize
        return result_array[current_number]
            
                
if __name__ == "__main__":
    print(Beakjoon_1463_solver.solve(int(input())))