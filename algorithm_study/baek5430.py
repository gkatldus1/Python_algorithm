'''
처음 풀었던 풀이.. 걍 reverse로 돌리면 될 줄 알았는데
시간이 너무 오래 걸림... 알아보니 R의 개수에 따라 앞과 뒤의 빼주는 수를 
파악하며 풀어야했다.
num = int(input())
for i in range(1, num+1) :
    func = input()
    arr_length = int(input())
    if(arr_length == 0) :
        arr = input()
        arr = []
    else :
        arr =  list(map(int, input()[1:-1].split(',')))
    flag = False
    for element in func :
        if element == 'R' :
            arr.reverse()
        elif len(arr) < 1 :
            print('error')
            flag= True
            break
        else :
            arr.pop(0)
    if flag == True:
        continue
    else :
        print(str(arr).replace(' ', ''))
'''
'''
구글에서 찾은 갓갓이 풀이한 코드. R에 따라 앞과 뒤에서 빼주는 수를 센 후
마지막에 슬라이싱으로 한번에 숫자를 버림
ㄷㄷ 어떻게 저렇게 짤 수 있는지 후.. 한숨만 ㅎㅎ
'''


for i in range(int(input())):
    q = input()
    arr_len = int(input())
    if(arr_len == 0):
        input_arr = input()
        input_arr = []
    else:
        input_arr = list(map(int, input()[1:-1].split(',')))
    is_reverse = False
    is_ok = True
    front = 0
    rear = 0
    
    for act in q:
        try:
            if(act == 'R'):
                is_reverse = not is_reverse
            elif(act == 'D' and not is_reverse):
                front += 1
            elif(act == 'D' and is_reverse):
                rear += 1
        except:
            is_ok = False
            print('error')
            break

    if(is_ok):
        if(front + rear <= arr_len):
            if(not is_reverse):
                input_arr = input_arr[front:arr_len - rear]
                print(str(input_arr).replace(' ', ''))
            else:
                input_arr = input_arr[::-1][rear:arr_len - front]
                print(str(input_arr).replace(' ', ''))
        else:
            print('error')

