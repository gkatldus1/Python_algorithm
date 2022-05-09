T = int(input())

for i in range(T):
    str1 = input()
    str2 = input()
    if str1 in str2:
        print("#{} 1".format(i+1))
    else:
        print("#{} 0".format(i+1))