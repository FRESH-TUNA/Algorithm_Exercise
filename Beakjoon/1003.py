class Beakjoon_1003_solver:
    result_zero_array = [None] * 41
    result_one_array = [None] * 41

    @classmethod
    def solve(self, yourInput):
        result_zero_array = self.result_zero_array
        result_one_array = self.result_one_array
        for i in range(yourInput + 1):
            if result_zero_array[i] is None:
                result_zero_array[i] = result_zero_array[i-1] + result_zero_array[i-2]
                result_one_array[i] = result_one_array[i-1] + result_one_array[i-2]
        return str(result_zero_array[yourInput]) + ' ' + str(result_one_array[yourInput])

    @classmethod
    def service(self):
        numOfInput = int(input())
        self.result_zero_array[0] = 1
        self.result_one_array[0] = 0
        self.result_zero_array[1] = 0
        self.result_one_array[1] = 1

        for i in range(numOfInput):
            yourInput = int(input())
            print(self.solve(yourInput))

if __name__ == "__main__":
    Beakjoon_1003_solver.service()