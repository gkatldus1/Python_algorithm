characters = input()
ans = ""

for char in characters:
    if char.islower():
        ans += chr(ord(char)+13) if char <= 'm' else chr(ord(char) - 13)
    elif char.isupper():
        ans += chr(ord(char)+13) if char <='M' else chr(ord(char) - 13)
    else:
        ans += char
print(ans) 
