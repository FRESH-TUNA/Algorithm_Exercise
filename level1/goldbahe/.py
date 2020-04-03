
def 골드바흐이터레이션서비스():
  while(숫자 = input != 0):
    프린트(골드바흐(숫자))

def 숫자가볼드바흐면(숫자):
  if 숫자 > 4 and 숫자 & 2 == 0:
    골드바흐이다.
  else:
    골드바흐가아니다.

def 골드바흐(숫자):
  if 숫자가골드바흐면(숫자):
    return n을만들수있는방법중가장큰것(n)
  else:
    return "Goldbach's conjecture is wrong."

def n을만들수있는방법중가장큰것(숫자)
  숫자A = 2
  숫자B = 숫자 - 2
  
  while (숫자A < 숫자B):
    if 소수(숫자A) and 소수(숫자B):
      return 출력(숫자A, 숫자B)
    else:
      숫자A += 1
      숫자B -= 1

  return "Goldbach's conjecture is wrong."

def 가능한소수들만골라내기(숫자)
  숫자배열 = [false] * (숫자 + 1)
  
  while 인덱스, 값 in 숫자배열:
    if 소수(인덱스) and 소수(숫자 - 인덱스):
      return 출력(숫자A, 숫자B)
    else:
      배열안숫자의곱하기되는친구들비활성화(인덱스, 숫자배열)

def 배열안숫자의곱하기되는친구들비활성화(인덱스, 숫자배열):
  while 인덱스 <= 총갯수(숫자배열):
    인덱스 비활성화
    인덱스 += 인덱스

