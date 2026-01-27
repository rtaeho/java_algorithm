import sys

# 세 줄에 걸쳐 입력되는 A, B, C를 읽어옵니다.
a = int(sys.stdin.readline())
b = int(sys.stdin.readline())
c = int(sys.stdin.readline())

# 합이 21 이하인지 확인하여 조건에 맞춰 출력합니다.
if a + b + c <= 21:
    print(1)
else:
    print(0)