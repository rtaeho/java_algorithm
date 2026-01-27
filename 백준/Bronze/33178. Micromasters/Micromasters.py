import sys

# 추천인 수 n을 입력받습니다.
n = int(sys.stdin.readline())

# 10명당 1과목이 무료이므로 10으로 나눈 몫을 출력합니다.
print(n // 10)