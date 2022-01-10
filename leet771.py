import collections

class numJewel:
    def numJewelsInStones(self, J: str, S: str) -> int:
        freqs = {}
        count = 0

        for char in S:
            if char not in freqs:
                freqs[char] = 1
            else:
                freqs[char] += 1
        
        for char in J:
            if char in freqs:
                count += freqs[char]
        
        return count

    def numJewelsInStones1(self, J: str, S: str) -> int:
        freqs = collections.defaultdict(int)
        count = 0

        for char in S:
            freqs[char] += 1

        for char in J:
            count += freqs[char]

        return count

    def numJewelsInStones2(self, J: str, S: str) -> int:
        freqs = collections.Counter(S)
        count = 0

        for char in J:
            count += freqs[char]
        
        return count

    def numJewelsInStones3(self, J: str, S: str) -> int:
        return sum(s in J for s in S)