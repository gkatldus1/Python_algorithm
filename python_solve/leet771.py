import collections

def numJewelsInStones(self, jewels: str, stones: str) -> int:
    freqs = {}
    count = 0

    for char in stones:
        if char in freqs:
            freqs[char] += 1
        else:
            freqs[char] = 1
    for char in jewels:
        if char in freqs:
            count += freqs[char]
    return count

def numJewelsInStones(self, jewels: str, stones: str) -> int:
    freqs = collections.defaultdict(int)
    count = 0

    for char in stones:
        freqs[char] += 1
    
    for char in jewels:
        count += freqs[char] 
    
    return count

def numJewelsInStones(self, jewels: str, stones: str) -> int:
    freqs = collections.Counter(stones)
    count = 0

    for char in jewels:
        count += freqs[char]
    
    return count

def numJewelsInStones(self, jewels: str, stones: str) -> int:
    return sum(s in jewels for s in stones)