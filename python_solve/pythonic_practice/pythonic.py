# 1~10을 담는 리스트를 만들어보자
#[expression for component in input_sequence <if statement>]
_list = [num for num in range(1,11)]

# 2, 4, 6, 8, ...20을 담는 리스트
_list = []
_list = [num * 2 for num in range(1, 11)]

#주어진 리스트를 받아서 3의 배수만 저장하자
ref = [23, 42, 15, 67,83, 81]

_list=[num for num in ref if num % 3 == 0]

#값이 두개 들은 튜플을 담은 리스트를 받아 리스트를 생성하되 튜플 내용을 뒤집어라
adkfla = [(2,3) (1,4), (5,6), (6,1), (2,7)]
_list = [(b, a) for a, b in adkfla]

#주어진 리스트를 그대로 담되, 15가 넘는 숫자는 15로 저장하는 리스트를 만들어봅시다.
ref = [2,4,26,15,13,12,11,16,14]
_list = [num if num <= 15 else 15 for num in ref]
