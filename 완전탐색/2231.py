N=int(input())

for i in range(1, N+1):
    result = i + sum(map(int, str(i))) #계산하여 구할 분해합
    if result == N: #생성자가 있는 경우
        print(i)
        break
    if i == N: #생성자가 없는 경우
        print(0)

