A, B = map(int, input().split())
C = int(input())

# 분을 추가
B = B + C  # 총 걸리는 분 수

# 시간과 분 조정
A = A + (B // 60)  # 시간을 A에 더하고
B = B % 60  # 남은 분을 B에 저장

A = A % 24  # 24시간을 넘어가면 0으로 초기화

print(A, B)