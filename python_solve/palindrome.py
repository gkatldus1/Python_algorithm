def palindrome(data) :
    '''
    문자열 data가 주어질 때, 이를 팰린드롬으로 만들기 위해 제거해야 하는 문자 개수의 최솟값을 반환하는 함수를 작성하세요.
    '''
    n = len(data)
    
    p = [[0]*n for i in range(n)]
    
    for i in range(n-2, -1, -1) :
        for j in range(i+1, n) :
            if data[i] == data[j] :
                p[i][j] = p[i+1][j-1]   
            else :
                p[i][j] = min(p[i+1][j], p[i][j-1]) + 1
            
    
    

    return p[0][len(data)-1]