N, M = map(int, input().split())

basket = [0] * N  # 빈 바구니 생성

for _ in range(M):
    i, j, k = map(int, input().split())
    # i부터 j까지 바구니에 k를 넣어라
    for index in range(i - 1, j):
        basket[index] = k

print(*basket)
