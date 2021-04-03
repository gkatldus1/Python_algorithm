from typing import List
def trap(height: List[int]) -> int:
    # if not height:
    #     return 0
    # volume = 0
    # left, right = 0, len(height) -1
    # left_max, right_max = height[left], height[right]
    #
    # while left < right:
    #     left_max, right_max = max(height[left], left_max), max(height[right], right_max)
    #
    #     if left_max <= right_max:
    #         volume += left_max - height[left]
    #         left += 1
    #     else:
    #         volume += right_max - height[right]
    #         right -= 1
    # return volume
#      위에는 투포인터 풀이 밑에는 스택으로 풀이
    stack = []
    volume = 0

    for i in range(len(height)):
        while stack and height[i] > height[stack[-1]]:
            top = stack.pop()

            if not len(stack):
                break

            distance = i - stack[-1] -1
            waters = min(height[i], height[stack[-1]]) - height[top]
            volume += distance * waters

        stack.append(i)
    return volume


height = list(map(int, input("입력:").split(",")))
answer = trap(height)
print(answer)