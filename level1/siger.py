def calculator(inputListData, n):
    for index, value in enumerate(inputListData):
        if value != ' ':
            current_char_asc = ord(inputListData[index])
            newchar = None
            
            if current_char_asc == ord('z'):
                newchar = 'a'
            elif current_char_asc == ord('Z'):
                newchar = 'A'
            else:
                newchar =  chr(current_char_asc + n)
            inputListData[index]  =  newchar
    return ''.join(inputListData)
    
    
def solution(s, n):
    return calculator(list(s), n)

if __name__ == "__main__":
    print(solution('AB', 1))