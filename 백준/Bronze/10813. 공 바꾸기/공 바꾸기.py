N, M = map(int, input().split())
# N은 바구니 개수
# M은 교환 횟수
# N = 7
# 1 2 3 4 5 6 7
# M번 반복하면서 공을 교환
basket = [0] * N
for i in range(N):
    # i : 0 ~ N - 1 횟수는 N번
    # i : 1 ~ N 횟수는 N번
    basket[i] = i + 1
# basket[0], basket[1], ... basket[N - 1] -> N개의 배열 index
# 공 -> 1 ~ N
for _ in range(M):
    i, j = map(int, input().split())
    # i번째와 j번째의 공을 바꿔라
    basket[i - 1], basket[j - 1] = basket[j - 1], basket[i - 1]

print(*basket)