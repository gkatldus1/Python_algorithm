def bin_search(page, target):
    left = 1
    right = page
    count = 0
    while left <= right:
        mid = int((left + right) / 2)
        if mid == target:
            count += 1
            return count
        elif mid < target:
            left = mid 
            count += 1
        elif mid > target:
            right = mid 
            count += 1
T = int(input())
for i in range(T):
    P, A, B = map(int, input().split())
    A_count = bin_search(P, A)
    B_count = bin_search(P, B)
    
    if A_count < B_count:
        print("#{} A".format(i+1))
    elif A_count > B_count:
        print("#{} B".format(i+1))
    else:
        print("#{} 0".format(i+1))
