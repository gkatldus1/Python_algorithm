import itertools
iter = itertools.combinations('1234', 2)

print(list(iter))
for data in iter:
    print(' '.join(map(str,data)))

iter = itertools.permutations('1234', 2)

for data in iter :
    print(*data)

iter = itertools.combinations_with_replacement('1234',2)

for data in iter:
    x, y = data
    print(x, y)

iter = itertools.product('1234', repeat=2)
print(list(iter))
for data in iter:
    print('{}{}'.format(*data))

