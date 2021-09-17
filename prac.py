import sys
from collections import Counter

# c = Counter(a=4, b=2, c=0, d=-2)
# print(c)
# print(sorted(c.elements()))

# print(Counter('abraccadabra'))
# print(Counter([1,1,2,3,5,3,2,1]))
N = int(sys.stdin.readline())
cards = [int(sys.stdin.readline()) for _ in range(N)]

# print(cards)

count = Counter(cards)
print(count)

count = Counter(sorted(cards))
print(count)
print(count.most_common(1)[0][0])
