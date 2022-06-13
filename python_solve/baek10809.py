graph = 'abcdefghijklmnopqrstuvwxyz'
_dict = {}
for i in graph:
    _dict[i] = -1
value = input()

for i in value:
    _dict[i] = value.find(i)

print(' '.join(map(str,_dict.values())))

