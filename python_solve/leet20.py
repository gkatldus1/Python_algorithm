def isValid(self, s: str) -> bool:
    table = {
            ')':'(',
            '}':'{',
            ']':'['
        }
    stack = []
    for elem in s:
        if elem not in table:
            stack.append(elem)
        else:
            if len(stack) == 0:
                return False
                
            if table[elem] != pop:
                return False
    if stack:
        return False
    else:
        return True

def isValid(self, s: str) -> bool:
    stack = []
    table = {
        ')':'(',
        '}':'{',
        ']':'[',
    }

    for char in s:
        if char not in table:
            stack.append(char)
        elif not stack or table[char] != stack.pop():
            return False
    return len(stack) == 0


