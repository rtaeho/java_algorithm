a, b, c = map(int, input().split())
# 1. 세 개가 같은 수
# 2. 두 개만 같은 수
# 3. 모두 다른 수

if a == b == c:
    print(10000 + a * 1000)
elif a == b or b == c:
    print(1000 + 100 * b)
elif c == a:
    print(1000 + 100 * a)
else:
    print(max(a, b, c) * 100)
