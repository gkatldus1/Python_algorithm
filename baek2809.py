from collections import deque
def makeTrie(words):
    trie = {}
    for w in words:
        cd = trie
        for l in w: cd = cd.setdefault(l, {})
        cd[''] = len(w)
    trie["ROOT"] = ''; Q = deque(); Q.append(trie)
    while len(Q):
        p = Q.popleft()
        for c in p:
            if c in ('', "ROOT", "FAIL", "OUT"): continue
            pp = p; q = p[c]
            if type(q) == str: continue
            while 1:
                if "ROOT" in pp: q["FAIL"] = pp; break
                pf = pp["FAIL"]
                if c in pf: q["FAIL"] = pf[c]; break
                else: pp = pf
            Q.append(q)
        if "ROOT" in p: continue
        elif '' in p: p["OUT"] = p
        elif "OUT" in p["FAIL"]: p["OUT"] = p["FAIL"]["OUT"]; p[''] = p["FAIL"]['']
    return trie

def AhoCorasick(s, trie):
    p = trie; i = 0; match = []
    while i <= len(s):
        if "OUT" in p: match.append((i-p['']+1, i))
        if i == len(s): break
        if s[i] in p: p = p[s[i]]; i+= 1; continue
        if "ROOT" in p: i+= 1
        else: p = p["FAIL"]
    return match

n = int(input())
street = input()
m = int(input())
words = [input() for i in range(m)]
match = AhoCorasick(street, makeTrie(words))
event = []
for i, j in match:
    event.append((i-1,-1))
    event.append((j,1))
event.sort()

un = 0
layer = 0
pointer = 0
for i in range(n):
    while pointer < len(event) and event[pointer][0] <= i:
        layer-= event[pointer][1]
        pointer+= 1
    if not layer: un+= 1
print(un)