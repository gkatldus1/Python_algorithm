import sys
import math
input = sys.stdin.readline

N = int(input())
max = 0
most = -math.inf
my_dict = {}

for i in range(N):
    num = int(input())

    if num not in my_dict.keys():
        my_dict[num] = 1
    else:
        my_dict[num] = my_dict[num] + 1

sorted_dict = sorted(my_dict.items())

for i in range(len(sorted_dict)):
    if(sorted_dict[i][1] > max):
        max = sorted_dict[i][1]
        most = sorted_dict[i][0]
print(most)