import sys

def fKnapsack(materials, m) :
    '''
    크기 m까지 버틸 수 있는 베낭이 담을 수 있는 최대 가치를 반환하는 함수를 작성하세요.

    주의 : 셋째 자리에서 반올림하는 것을 고려하지 않고 작성하셔도 됩니다. 
    '''

    materials = sorted(materials, key = lambda x : x[1] / x[0], reverse = True)
    
    weight = 0
    value = 0
    
    for i in range(len(materials)) :
        '''
        1. 물건을 넣고 더 넣을 여유 공간이 있을때
        2. 물건을 넣으면 다 찰때
        3. 물건을 넣으면 m을 넘어갈 때
        '''
        if weight + materials[i][0] < m :
            weight += materials[i][0]
            value += materials[i][1]
        elif weight + materials[i][0] == m :
            value += materials[i] [1]
            
            return value
        else :
            temp = m - weight 
            value += temp * (materials[i][1]/materials[i][0])
            return value
    
    return value
        

    

def main():
    
    line = [int(x) for x in input().split()]

    n = line[0]
    m = line[1]

    materials = []

    for i in range(n) :
        data = [int(x) for x in input().split()]
        materials.append( (data[0], data[1]) )

    print("%.3lf" % fKnapsack(materials, m))

if __name__ == "__main__":
    main()
