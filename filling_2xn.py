import sys
sys.setrecursionlimit(100000)


def fillBox(n) :
    '''
    2 x n 의 상자를 2 x 1 의 블럭으로 채우는 경우의 수를 1,000,000,007로 나눈 나머지를 반환하는 함수를 작성하세요.
    '''
    #memo = {}
    #MOD = 1e9 + 4
    #if n == 0 or n == 1 : return 1
    
   # if n in memo : return memo[n]
   # else :
    #    memo[n] = fillBox(n-1) + fillBox(n-2) % MOD
   # return memo[n] 
    
    T = [1, 1]
    for i in range(2, n+1) :
        T.append((T[i-1] + T[i-2])%(1e9+7))
    return T[n]
    