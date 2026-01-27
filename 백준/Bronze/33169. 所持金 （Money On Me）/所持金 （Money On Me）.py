import sys

# 첫 번째 줄에서 1,000엔 지폐의 수 A를 입력받음
a = int(sys.stdin.readline())
# 두 번째 줄에서 10,000엔 지폐의 수 B를 입력받음
b = int(sys.stdin.readline())

# 총액 계산 후 출력
print(1000 * a + 10000 * b)