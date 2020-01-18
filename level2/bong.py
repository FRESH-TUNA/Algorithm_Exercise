def solution(arrangement):
    is_bong = True
    next_type = not is_bong
    type_stack = []
    bong_list = []
    laser = []
    answer = 0
    

    # ( 레이저

    # ( 레이저
    # (( 레이저 막대기
    # ((( 레이저 막대기 막대기
    # (((( 레이저 막대기 막대기 막대기
    # ((( 막대기 막대기 막대기


    for index, value in enumerate(arrangement):
        if value == ')':
            if type_stack[0][0] is is_bong:
                bong_list = bong_list + [[type_stack[0][1], index, 1]]
            else:
                laser = laser + [type_stack[0][1]]
            next_type = not is_bong
            type_stack = type_stack[1:]
        elif next_type is is_bong:
            type_stack = type_stack + [[next_type, index]]
        else:
            type_stack = [[next_type, index]] + type_stack
            next_type =  is_bong
    
    print(bong_list)
    print(laser)
    for x in bong_list:
        for y in laser:
            if y > x[0] and y < x[1]:
                x[2] = x[2] + 1
        answer = answer + x[2] 
        

    
    return answer

print(solution("()(((()())(())()))(())"))