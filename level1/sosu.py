# def determine(n):
#     for x in range(2, n//2 + 1):
#         if n % x == 0:
#             return False
#     return True

# def solution(n):
#     return len(list(filter(determine, range(3, n+1, 2)))) + 1


def solution(n):
    count = 0
    datas =  list(range(2, n+1))
    for index, value in enumerate(datas):
        if value == 0:
            continue
        else:
            count = count + 1
            sub_index = index + value
            while sub_index < n - 1:
                datas[sub_index] = 0
                sub_index = sub_index + value  
    return count

if __name__ == "__main__":
    a = int(input())
    print(solution(a))
