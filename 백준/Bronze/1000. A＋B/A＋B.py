ab = input() # "1 2" -> string(문자열) " "
a, b = ab.split() # ['1', '2'] -> '1' -> char(문자) ' '
# a = '1' -> 문자
# b = '2' -> 문자
# 문자 -> 숫자
# 숫자 : 정수, 실수
# 정수 : Integer
# 실수 : Float
print(int(a) + int(b)) # '1' + '2' = '12'
# split() 공백(space)를 기준으로 자름
# 1 2
