def min_to_correct_char(character):
    up_count = ord(character) - ord('A')
    down_count = ord('Z') - ord(character) + 1
    return min(up_count, down_count)

def calculate_right_count(index, name):
    count = 0
    for i in range(1,len(name)):
        if name[index+i]=="A": count += 1
        else: break
    return count + 1

def calculate_left_count(index, name):
    count = 0
    for i in range(1,len(name)):
        if name[index-i]=="A": count += 1
        else: break
    return count + 1

def solution(name):
    answer = 0
    # string을 리스트화 하여 필요한 메소드와 마이너스 index를 사용한다.
    name = list(name)
    objective_name = ["A"] * len(name)
    index = 0

    while(True):
        if name[index] != 'A': 
            answer += min_to_correct_char(name[index])
        
        name[index] = 'A'

        if name == objective_name: break

        left_count = calculate_left_count(index, name) 
        right_count = calculate_right_count(index, name)

        if right_count < left_count:
            answer += right_count
            index += right_count
        else:
            answer += left_count
            index -= left_count
            
    return answer
