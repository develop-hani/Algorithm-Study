while 1:
    cnt = 0
    sentence = input()
    c = sentence[0]
    str = sentence[2:]
    
    if c == '#':
        break

    for i in range(len(str)):
        if c == str[i].lower():
            cnt += 1

    print(c, cnt)

#문자열을 통채로 입력받음 => 분해하는 과정있음
#.lower() 함수로 문자열을 모두 소문자로 만들어 비교
