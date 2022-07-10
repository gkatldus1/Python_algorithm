import sys

def coinChange(n) :
    '''
    n원을 돌려주기 위해 필요한 동전 개수의 최솟값을 반환하는 함수를 작성하세요.
    '''
    
    result = 0
    
    coins = [100, 50, 10, 5, 1]
    
    for coin in coins :
        result += n // coin
        
        n = n % coin #지불하고 남은 금액

    return result

def main():
    

    n = int(input())

    print(coinChange(n))

if __name__ == "__main__":
    main()