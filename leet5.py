class Solution:
    def longestPalindrome(self, s: str) -> str:
        answer = ''
        def palindrome(s: str) -> bool:
            if s == s[::-1]:
                return True
            else:
                return False
            
        
        if len(s) == 2 and not palindrome(s):
            return s[0]
        if palindrome(s):
            return s
        
        
        for i in range(1, len(s) - 1):
            left = i - 1
            right = i + 1
            while left >= 0 and right < len(s):
                if palindrome(s[left:right]) and len(s[left:right]) > len(answer):
                    # print(s)
                    answer = s[left:right]
                if palindrome(s[i:right + 1]) and len(s[i:right + 1]) > len(answer):
                    # print(s)
                    answer = s[i:right + 1]
                if palindrome(s[left:right + 1]) and len(s[left:right + 1]) > len(answer):
                    # print(s[left:right + 1])
                    answer = s[left:right + 1]
                left -= 1
                right += 1
        if answer:
            return answer
        return s[0]
    

    def longestPalindrome(self, s: str) -> str:
        def expand(left: int, right: int) -> str:
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return s[left + 1:right]

        if len(s) < 2 or s == s[::-1]:
            return s
        result = ''

        for i in range(len(s) - 1):
            result = max(result, 
                            expand(i, i + 1),
                            expand(i, i + 2),
                            key=len)
        return result