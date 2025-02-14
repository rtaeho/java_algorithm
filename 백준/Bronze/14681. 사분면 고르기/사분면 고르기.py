x = int(input())
y = int(input())

if x > 0:
    if y > 0:
        print(1)
    else:  # y < 0
        print(4)
else:  # x < 0
    if y > 0:
        print(2)
    else:  # y < 0
        print(3)
