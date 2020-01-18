def solution(bridge_length, weight, truck_weights):
    current_weight = 0
    truck_weights =  [[x,bridge_length] for x in truck_weights]
    passing_weights = list()
    time = 1
    
    while len(truck_weights) != 0 or len(passing_weights) != 0:
        time = time + 1
        if len(truck_weights) != 0 and current_weight + truck_weights[0][0] <= weight:
            passing_weights = [truck_weights[0]] + passing_weights 
            current_weight = current_weight + truck_weights[0][0]
            truck_weights = truck_weights[1:]
            
        
        passing_weights = list(map(lambda x:  [x[0], x[1] - 1], passing_weights))
        print(passing_weights)
        if passing_weights[-1][1] == 0:
            current_weight = current_weight - passing_weights[-1][0]
            passing_weights = passing_weights[:-1]
    
    return time

if __name__ == "__main__":
    print(solution(100,	100, [10,10,10,10,10,10,10,10,10,10]))