import sys
input = sys.stdin.readline
r = 1000000
primes = [True for _ in range(1000000)]
for i in range(2, int(r**0.6)):
    if primes[i] == True:
        for j in range(i*2, r, i):
            if primes[j] == True:
                primes[j] = False

while(True):
    n = int(input())

    if n == 0:
        break
    for i in range(3, r):
        if primes[i] == True:
            if primes[n-i] == True:
                print("%d = %d + %d"%(n, i, n-i))
                break

