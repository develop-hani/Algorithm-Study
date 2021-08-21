N=int(input())

for i in range(1, N+1):
    result = i + sum(map(int, str(i))) #계산하여 구할 분해합
    if result == N: #생성자가 있는 경우
        print(i)
        break
    if i == N: #생성자가 없는 경우
        print(0)

#해결하지 못한 부분
#N은 최대 6자리. 이 경우 각 자리수의 합이 54인 경우가 최대
#for i in range(N-54,N+1) 시도. 런타임에러 남
