import sys
import math
def getPowerSet(n, k) :
    '''
    1부터 n까지의 자연수의 원소가 있을 때 k를 가장 처음으로 선택하는 경우 반환
    '''
    if n == k :
        return [[k]]
    
    result = [[k]]
    
    temp = []
    
    for i in range(k+1, n+1) : 
        temp = temp + getPowerSet(n, i) 
        
    for i in range(len(temp)) : 
        temp[i] = [k] + temp[i] 
    
    return result + temp 



def powerSet(n) :
    '''
    n개의 원소를 가지는 집합 A의 멱집합의 원소를 사전 순서대로 list로 반환하는 함수를 작성하시오.

    예를 들어, n = 3 일 경우 다음의 list를 반환한다.

    [ [1], [1, 2], [1, 3], [1, 2, 3], [2], [2, 3], [3] ]
    '''
    
    result = []
    
    for i in range(1, n+1) :
        result += getPowerSet(n, i)
        

    return result

def makeEqual(data) :
    '''
    n개의 숫자를 두 그룹 A, B로 나눈다고 할 때,

    | (A의 원소의 합) - (B의 원소의 합) | 의 최솟값을 반환하는 함수를 작성하시오.
    '''
    combinations = powerSet(len(data))
    
    total = sum(data)
    result = math.inf
    print(combinations)
    for c in combinations :
        mySumA = 0
        mySumB = 0
        
        for i in c : 
            mySumA += data[i -1] 
            
            mySumB = total - mySumA 
            
        result = min(result, abs(mySumA - mySumB)) 
        
    
    
    
    

    return result

def main():
    
    data = [int(x) for x in input().split()]

    print(makeEqual(data))

if __name__ == "__main__":
    main()
