import sys

# 첫 번째 줄에서 시간 T를 입력받음
t = int(sys.stdin.readline())
# 두 번째 줄에서 속력 V를 입력받음
v = int(sys.stdin.readline())

# 거리 = 시간 * 속력
print(t * v)