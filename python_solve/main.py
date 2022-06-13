import sys

from eating import eating

def main():
    '''
    이 부분은 수정하지 마세요.
    '''

    n = int(input())

    data = []

    for i in range(n) :
        __line = [int(x) for x in input().split()]
        data.append(__line)

    print(eating(data))

if __name__ == "__main__":
    main()
