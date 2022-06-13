import sys
input = sys.stdin.readline

def init():
	seg[L:L+N] = [1] * N
	for i in range(L-1, 0, -1):
		seg[i] = seg[i*2] + seg[i*2+1]

def update(idx, val):
	pos = idx + L
	seg[pos] = val
	pos //= 2
	while pos:
		seg[pos] = seg[pos*2] + seg[pos*2+1]
		pos //= 2
	
def kth(k):
	p = 1
	while k:
		if p*2 >= L*2:
			if seg[p]:
				return p-L
			else:
				return p+1-L
		piv = seg[p*2]
		if piv >= k:
			p *= 2
		else:
			k -= piv
			p = p*2+1
	return p-L

N, K = map(int, input().split())
L = 2 ** N.bit_length()
seg = [0] * (L*2)

init()
ans = []
p = K
for i in range(N, 0, -1):
	idx = kth(p)
	update(idx, 0)
	ans.append(str(idx+1))
	if i != 1:
		p = (p+K-1) % (i-1)
	else:
		p = p+K-1
	if not p:
		p = i-1
		
print(f"<{', '.join(ans)}>")