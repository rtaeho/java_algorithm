# 첫째 줄에 (A+B)%C, 
# 둘째 줄에 ((A%C) + (B%C))%C, 
# 셋째 줄에 (A×B)%C, 
# 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
# "A B C"
# input() -> 엔터를 기준으로 한 줄을 입력
# input()을 한 번만 사용하면 "A B C"
# a, b, c = input() # "A B C"
string = input()
# string = "A B C"
A, B, C = string.split()
A = int(A)
B = int(B)
C = int(C)
# A = 'A', B = 'B', C = 'C'
print((A + B) % C)             
print(((A % C) + (B % C)) % C)  
print((A * B) % C) 
print(((A % C) * (B % C)) % C)