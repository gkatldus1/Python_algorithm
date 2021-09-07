n = list(map(int,input()))
l = len(n)
dp = [0 for _ in range(l+1)]
if (n[0] == 0) :
    print("0")
else :
    n = [0] + n
    print(n)