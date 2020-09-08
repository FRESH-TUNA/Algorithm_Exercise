def solution(board):
    i, j, answer = [0, 0, 0]
    while i < len(board):
        while j < len(board[i]):
            if i > 0 and j > 0 and board[i][j] > 0:
                board[i][j] += min(board[i - 1][j], board[i][j - 1], board[i - 1][j - 1])
            if board[i][j] > answer: answer = board[i][j]
            j += 1
        i += 1
        j = 0
    return pow(answer, 2)

if __name__ == '__main__':
    solution([[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]])
