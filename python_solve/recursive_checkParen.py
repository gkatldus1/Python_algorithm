def checkParen(p):
    if len(p) == 0 :
        return "YES"
    elif len(p) == 1 :
        return "NO"
    #기저 조건을 설정해줘야 재귀적 풀이법에서 탈출이 가능함    
    for i in range(len(p) - 1) :
        if p[i] == '(' and p[i+1] == ')' :
            q = p[:i] + p[i+2:]
            return checkParen(q)
    return "NO"
        

def main():
   

    x = input()
    print(checkParen(x))

if __name__ == "__main__":
    main()



