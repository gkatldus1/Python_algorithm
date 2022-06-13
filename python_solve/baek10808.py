# graph = 'abcdefghijklmnopqrstuvwxyz'
# dic = {}
# for i in graph:
#     dic[i] = 0
# for j in input():
#     dic[j] += 1
# print(' '.join(map(str, dic.values())))

str = input()

result =  [0] * 26

for i in str:
    result[ord(i) - 97] += 1

for i in result:
    print(i, end=" ")
