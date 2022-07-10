import re
from typing import List
import collections

def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
    paragraph = re.sub('[^\w]',' ', paragraph.lower()).split()
    count = collections.Counter(paragraph)
    ans = count.most_common(len(banned)+1)
    
    for i in range(len(banned)+1):
        if  not ans[i][0] in banned:
            return ans[i][0]

def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
    words = [word for word in re.sub(r'[^\w]', ' ', paragraph)
        .lower().split()
            if word not in banned]

    counts = collections.Counter(words)
    return counts.most_common(1)[0][0]
