'''
문제를 처음 보고 쌍이 맞는 괄호들의 위치를 파악하여 정리한 후, 조합으로 경우의 수에 따라
출력해주면 되겠다고 생각했습니다. 문제는 구현이었는데 어떻게 구현해야할지 감이 안잡히더라구요. ㅎ..
그런데 생각했던 방법으로 푸신 분이 계시길래 한번 코드를 가져와봤습니다. 
'''
from itertools import combinations 
import sys
input=sys.stdin.readline

problem = [*input().strip()]    # 쌍이 맞는 괄호들의 위치를 짝지어주기 위해 모든 문자열의 모든 문자 리스트화
p, idx_brs= [], []

for i, v in enumerate(problem):
    if v == '(': # 짝이 되는 여는 괄호의 위치 파악 및 여는 괄호를 제거
        problem[i] = ''
        p+=[i]
    if v == ')': 
        problem[i] = '' #짝이 되는 닫는 괄호와 여는 괄호를 리스트로 묶어주고, 닫는 괄호 제거
        idx_brs +=[[p.pop(), i]]

out = set()

for i in range(len(idx_brs)): 
    for j in combinations(idx_brs, i):  #idx_brs의 원소 i개를 뽑아 만들 수 있는 모든 조합을 j에 넣어줌
        P = problem[:]
        for v,w in j:   #나오는 경우의 수에 따라 괄호를 삽입한 후 set에 넣어줌
            P[v] = '('
            P[w] = ')'
        out.add(''.join(P))
for i in sorted(out):
    print(i)



