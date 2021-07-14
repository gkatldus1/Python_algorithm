from collections import Counter
import random

_list = [random.randrange(0,10) for i in range(1000)]
result = Counter(_list).most_common()
result2 = Counter(_list)
print(result)
print(result2)