import collections

k = int(input())
nums = [1,1,1,2,2,3]
freqs = collections.Counter(nums)
ans = []

for elem in freqs:
    if freqs[elem] >= k:
        ans.append(elem)

print(ans)


