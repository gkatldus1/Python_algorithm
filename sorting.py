def bubblesort(A):
    for i in range(1, len(A)):
        for j in range(0, len(A) - 1):
            if A[j] > A[j + 1]:
                A[j], A[j + 1] = A[j + 1], A[j]
    print(A)
bubblesort([3,2,4,5,1,7,8,6])

for i in range(1, len([3,2,4,5,1,7,8,6])):
    print(i)