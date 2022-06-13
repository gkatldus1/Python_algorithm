N = int(input())
answer = 0

def solution(data):
    global answer
    if len(data) == N:
        answer += 1
        return
    for i in range(1, N +1):
        isOk = True
        for j in range(len(data)):
            if data[j] == i or len(data) - j == abs(i-data[j]):
                isOk = False
                break
        if isOk:
            data.append(i)
            solution(data)
            data.pop()

solution([])
print(answer)