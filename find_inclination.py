import sys

def getSlope(a, b) :
    return abs((b[1] - a[1]) / (b[0] - a[0]))



def maxSlope(points) :
    '''
    n개의 점들 중에서 2개의 점을 선택했을 때, 얻을 수 있는 기울기의 절댓값 중에서 가장 큰 값을 반환하는 함수를 작성하세요.
    '''
    points.sort()
    
    result = 0
    
    for i in range(len(points) - 1) :
        
        result = max(result, getSlope(points[i], points[i+1]))
    

    return result

def main():
    
    n = int(input())
    points = []

    for i in range(n) :
        line = [int(x) for x in input().split()]
        print(line)
        points.append( (line[0], line[1]) )
        
    print(points)
    print("%.3lf" % maxSlope(points))

if __name__ == "__main__":
    main()
