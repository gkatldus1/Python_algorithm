def f(*params):
    print(params)

f('a', 'b', 'c')
f(1, 2, 3)
print('a', 'b', 'c')

date_info = {'year': '2020', 'month': '01', 'day':'7'}
new_info = {**date_info}
print(new_info)
new_info = {**new_info,'day':14}
print(new_info)
_list = [1,2,3,4,5,6,7]
print(*_list)
_tuple = (1,2,3,4,5,6,7)
print(*_tuple)
_list = [(1,3), (2,2)]
print(*_list)