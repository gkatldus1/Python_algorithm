from itertools import combinations
import sys

input = sys.stdin.readline


def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


t = int(input())

for i in range(t):
    final = []
    arr = [element for element in map(int, input().split())]
    arr = arr[1:]
    result = list(combinations(arr, 2))
    for j in result:
        final.append(gcd(j[0], j[1]))
    print(sum(final))

    # print(sum(result))
