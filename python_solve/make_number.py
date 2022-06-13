def makeNumber(n, m) :
    '''
    1 ~ m 까지의 수를 더하여 n을 만드는 경우의 수를 1,000,000,007로 나눈 나머지를 반환하는 함수를 작성하세요.
    '''
    
    # result = sum(result[n-i]) i = 1~m
    
    result = [1]
    MOD = 1e9+7
    for i in range(1, n+1) :
        sum_temp = 0
        for j in range(1, min(i, m) + 1) :
            sum_temp += result[i-j]
        result.append(sum_temp%MOD)
    
    
    

    return result[n]