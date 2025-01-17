a, b = map(int, input().split())
# 1. a > b
# 2. a < b
# 3. a = b
# a = 1, b = 2
if a > b:
    print(">")
elif a < b:
    print("<")
else:
    print("==")
# if (조건) :
#   조건이 참인 경우 할 행동
# elif (조건) :
#   조건이 참인 경우 할 행동
# else :
#   할 행동
