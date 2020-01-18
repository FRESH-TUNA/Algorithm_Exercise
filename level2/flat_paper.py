def solution(n):
    result = [0]
    x = 1
    insert_value = True
    while x < n:
        new_result = [0]
        for last_data in result:
            new_result = new_result + [last_data]
            if insert_value is True:
                new_result = new_result + [1]
            else:
                new_result = new_result + [0]
            insert_value = not insert_value
        result = new_result
        x = x + 1
        
    return result
    # result = [0]
    # x = 1
    # while x < n:
    #     result = result + result + [1]
    # return result

print(solution(2))