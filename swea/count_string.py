import collections

T = int(input())
for i in range(T):
    str1 = input()
    str2 = input()
    max_count = -1
    _dic = collections.Counter(str2)
    for letter in str1:
        if (letter in _dic) and _dic[letter] > max_count:
            max_count = _dic[letter]
    print("#{} {}".format(i+1, max_count))