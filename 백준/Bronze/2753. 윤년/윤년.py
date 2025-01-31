# 윤년의 조건
# 1. 4의 배수이면서 100의 배수가 아닐 때
# 2. 400의 배수일 때
year = int(input())

if year % 400 == 0:
    print(1)  # 400의 배수 (4의 배수이면서 100의 배수)
elif year % 100 == 0:
    print(0)  # 400의 배수가 아니면서 100의 배수 (4의 배수)
elif year % 4 == 0:
    print(1)
else:
    print(0)