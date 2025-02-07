a = input()
# a : "1 2"
a, b = a.split()
# a : '1', b : '2'
a = int(a)
b = int(b)
# a, b에 비교할 수가 저장

# 1. a가 b보다 큰 경우
# 2. a가 b보다 작은 경우
# 3. a와 b가 같은 경우

# if 조건 :
#   조건이 만족할 경우 실행
# a = 5, b = 5
if a < b:
    print("<")
elif a > b:
    print(">")
else:
    print("==")