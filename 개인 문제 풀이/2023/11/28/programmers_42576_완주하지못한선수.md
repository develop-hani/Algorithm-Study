# Programmers 42576번 완주하지 못한 선수

[Programmers 42576번 완주하지 못한 선수](https://school.programmers.co.kr/learn/courses/30/lessons/42576)

### 🤔 문제 이해하기
마라톤에 참여한 선수 중 완주하지 못한 선수가 딱 1명 있다.

참여한 선수와 완주한 선수의 이름이 담긴 배열이 각각 존재할 때, 완주하지 못한 선수의 이름을 구하여라.

### ⭐ 알고리즘
- 정렬

### 📖 스토리 라인
1. 두 배열을 이름 순서로 정렬한다.
2. 순서대로 비교하며 두 배열의 이름이 같지 않다면, 그 선수가 완주하지 못한 선수이다.

### 💻 문제를 해결한 코드

```java
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(completion);
        Arrays.sort(participant);
        
        for (int i = 0; i < completion.length; ++i) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        
        return participant[participant.length - 1];
    }
}
```
