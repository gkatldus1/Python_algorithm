def checkParen(p):
    if len(p) == 0 :
        return "YES"
    elif len(p) == 1 :
        return "NO"
        
    for i in range(len(p) - 1) :
        if p[i] == '(' and p[i+1] == ')' :
            q = p[:i] + p[i+2:]
            return checkParen(q)
    return "NO"
        

def main():
    '''
    이 부분은 수정하지 마세요.
    '''

    x = input()
    print(checkParen(x))

if __name__ == "__main__":
    main()



