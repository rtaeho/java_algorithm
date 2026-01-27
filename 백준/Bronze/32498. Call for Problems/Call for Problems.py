import sys

# 첫 번째 줄에서 문제의 수 n을 입력받음
n = int(sys.stdin.readline())

excluded_count = 0

for _ in range(n):
    # 각 문제의 난이도 d를 입력받음
    d = int(sys.stdin.readline())
    
    # 난이도가 홀수라면 카운트 증가
    if d % 2 != 0:
        excluded_count += 1

# 최종 결과 출력
print(excluded_count)