t = int(input())
for tc in range(1,t+1):
    s = input().split()
    
    stack = []
    for n in s:
        if n=='.':
            if len(stack)==1:
                print("#"+str(tc),stack.pop())
            else:
                print("#"+str(tc),'error')
                break
        elif n.isdigit():
            stack.append(int(n))
        else:
            if len(stack)<2:
                print("#"+str(tc),'error')
                break
            else:
                b = stack.pop()
                a = stack.pop()
                
                if n=='+':
                    stack.append(a+b)
                elif n=='-':
                    stack.append(a-b)
                elif n=='/':
                    stack.append(a//b)
                elif n=='*':
                    stack.append(a*b)