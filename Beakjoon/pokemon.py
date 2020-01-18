def solution(arr):
    total_pokemon = len(arr)
    max_pokemon = total_pokemon // 2
    ex_list = list(set(arr))

    if len(ex_list) > max_pokemon:
        return max_pokemon
    else:
        return len(ex_list)

if __name__ == "__main__":
    print(solution([3 ,3, 3, 2, 2, 2]))



