T = int(input())
for i in range(T):
    N,M = map(int, input().split())
    count = 0
    
    for i in range(N, M+1):
        tmp = str(i)
        count += tmp.count('0')
        
    print(count)
