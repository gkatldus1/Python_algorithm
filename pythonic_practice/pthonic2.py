k번째
result = []
for idx in range(len(myInput)):
    if idx < k - 1 :
        result.append(-1)
    else:
        tmp_arr = sorted(myInput[:idx + 1])
        result.append(tmp_arr[k-1])

순열구하기
from itertools import permutations
from string import ascii_lower

def getPermuatation(n, r) :
    result = []
    perm = itertools.permutations(ascii_lowercase[:n], r)
    result = []
    for dt in perm:
        print(dt)
        result.append(''.join(dt))
    return result
