import operator
class Car:
    def __init__(self, **kwargs):
        self.cases = list()

class Case:
    def __init__(**kwargs):
        self.time = kwargs['time']
        self.distance = kwargs['distance']

def input_cases():
    cars = dict()
    while input_temp = input() != None:
        input_list = input_temp.split()
        if cars[input_list[0]] != None:
            cars[input_list[0]] = Car()
        cars[input_list[0]].cases.append(input_list[1:])
    cars[input_list[0]].cases.sort(key = operator.itemgetter(1))
    return cars

def calculate(cars)
def service(num_of_testcase):
    input()
    for _ in range(num_of_testcase):
        cars = input_cases()
        calculate(cars)
            # if input_list[2] = 'enter':
            #     if cars[input_list[0]].enter is None:
            #         cars[input_list[0]].enter = input_list[1]
            #     else:
            #         continue
            # elif cars[input_list[0]].enter is None:
            #     cars[input_list[0]].exit = input_list[3]

if __name__ == "__main__":
    num_of_testcase = int(input())
    service(num_of_testcase)