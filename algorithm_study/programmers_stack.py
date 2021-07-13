from collections import deque

def solution(progresses, speeds):
    answer = []
    deq_p = deque() 
    deq_s = deque()
    for i in progresses :  
        deq_p.append(i)
    for i in speeds :
        deq_s.append(i)
    
    time = 0 # 경과한 시간
    count = 0 # 배포되는 기능 카운트
    while len(deq_p) > 0:
        
        if deq_p[0] + time*deq_s[0] >= 100 : #완료된 기능이라면 count를 증가시키고 기능과 개발 속도를 덱에서 빼줌
            count += 1
            deq_s.popleft()
            deq_p.popleft()
            
        else:
            if count >= 1:  #함께 출시될 기능들을 answer에 추가해줌
                answer.append(count)
                count = 0 
            time += 1
    answer.append(count)    #마지막 카운트를 추가시켜줌
    return answer