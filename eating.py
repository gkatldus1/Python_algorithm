def eating(data) :
    '''
    각 날짜 별 음식의 선호도가 list로 주어질 때, 상훈이가 얻을 수 있는 선호도 총합의 최댓값을 반환하는 함수를 작성하세요.
    '''
    # d[i][j] = max(d[i-1][k]) + data[i][j] (j!=k)

    days = len(data)
    d = [[0] *3 for i in range(days+1)]
    
    for i in range(1, days+1) :
        for j in range(3) :
            for k in range(3) :
                if j == k : continue
                d[i][j] = max(d[i][j], d[i-1][k])
                
            d[i][j] += data[i-1][j]
    print(d)
    return max(d[days][i] for i in range(3))
                
            
n = int(input())

data = []

for i in range(n) :
    line = [int(x) for x in input().split()]
    data.append(line)
eating(data)