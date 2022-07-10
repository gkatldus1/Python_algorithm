import sys
import math


def getSubsum(data) :
    result = -math.inf
    temp = 0

    for start in range(0, len(data)) :
        for end in range(start, len(data)) :
            temp = 0
            for i in range(start, end + 1) :
                temp += data[i]
            result = max(result, temp)

    return result

def main():
    

    data = [int(x) for x in input().split()]

    print(getSubsum(data))

if __name__ == "__main__":
    main()