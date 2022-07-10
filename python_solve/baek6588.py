# import sys
# input = sys.stdin.readline
# r = 1000000
# primes = [True for _ in range(1000000)]
# for i in range(2, int(r**0.6)):
#     if primes[i] == True:
#         for j in range(i*2, r, i):
#             if primes[j] == True:
#                 primes[j] = False

# while(True):
#     n = int(input())

#     if n == 0:
#         break
#     for i in range(3, r):
#         if primes[i] == True:
#             if primes[n-i] == True:
#                 print("%d = %d + %d"%(n, i, n-i))
#                 break
import sys

def Goldbach():
    check = [False, False] + [True] * 1000000

    for i in range(2, 1001):
        if check[i] == True:
            for j in range(i + i, 1000001, i):
                check[j] = False
    
    while True:
        n = int(sys.stdin.readline())

        if n == 0:
            break

        A = 3
        B = n - 3
        for _ in range(1000000):
            if check[A] and check[B]:
                print(f"{n} = {A} + {B}")
                break
            A += 1
            B -= 1
        else:
            print("Goldbach's conjecture is wrong")

Goldbach()
