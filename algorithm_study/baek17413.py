import sys

input=sys.stdin.readline

string = input().rstrip()
flag = False #태그 안의 단어인지 아닌지 분별하기 위한 플래그
ans = ""

for one in string :
    if flag == False:
        if one == '<' : #태그가 시작되면 정방향으로 단어를 만들어주며 플래그를 True로 바꿔준다
            temp += one
            flag = True
        elif one == " ": #공백이 나와서 역방향의 단어가 완성된 경우 문자열에 추가 및 temp 초기화
            temp += one
            ans += temp
            temp = ""
        else:
            temp = one + temp       #역방향으로 단어를 완성해가는 과정
    else :  #플래그가 True인 경우 
        if one == '>' : # 태그가 끝날 시 완성된 단어를 결과 문자열에 추가해준 후 temp 초기화하고 플래그를 False로
            temp += one
            ans += temp
            temp = ""
            flag = False
        else:
            temp += one

print(ans+temp)

