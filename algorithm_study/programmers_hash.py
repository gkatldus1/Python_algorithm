def solution(phone_book):
    
    answer = True
    dic = {}
    # dic = {i: j for i in range(len(phone_book)) for j in phone_book}
    # 처음엔 위와 같이 딕셔너리를 만들어줬더니 시간 효율성을 통과 못해서 밑에처럼
    #통과됨
    for pNumber in phone_book :
        dic[pNumber] = 1 #전화번호가 키 모든 value는 1
    for element in phone_book :
        temp = ""
        for one in element :
            temp += one  #전화번호를 쪼개서 앞에서부터 하나씩 붙여가며 딕셔너리를 탐색함
            if temp in dic and temp!= element :
                answer = False
    return answer