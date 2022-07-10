import sys
sys.setrecursionlimit(100000)

def convertBinary(n) :
    
    result = []
    
    if n == 1 :        
        result.append(1)
        return "".join(map(str,result))
    
    bit = n % 2
    result.append(bit)
    string = "".join(map(str, result))
    return convertBinary(n // 2) + string
    
    
    


def main():
    

    n = int(input())

    print(convertBinary(n))

if __name__ == "__main__":
    main()
