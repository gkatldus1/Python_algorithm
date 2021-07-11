num = int(input())
for i in range(1, num+1) :
    blank = (num-i) * ' '
    star = ['*'] * i
    result = " ".join(star)
    print(blank+result)