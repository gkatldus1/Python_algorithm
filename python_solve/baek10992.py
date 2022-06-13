num = int(input())
prev = 0
for i in range(1, num+1) :
    if i == num :
        print((2*i-1)*'*')
    elif i == 1:
        print((num-i)*' '+'*')
    else :
        print((num-i)*' '+'*'+((2*num-1)-2*(num-(i-1)))*' '+"*")