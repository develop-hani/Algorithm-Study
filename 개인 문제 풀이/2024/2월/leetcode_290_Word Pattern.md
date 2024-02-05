# leetcode 290 Word Pattern

[leetcode 290 Word Pattern]()

### 🤔 문제 이해하기

- pattern이 주어질 때, 문자열 s가 pattern과 같은 형태를 띄는지 파악하라.

### ⭐ 알고리즘

- 자료구조

### 📖 스토리 라인

확인해야할 것

- pattern의 길이와 주어진 문자의 수가 같은 것
- pattern의 문자와 s의 단어가 1:1로 매칭할 것

### 💻 문제를 해결한 코드

```java
import java.util.*;
import java.io.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> match = new HashMap<>();
        StringTokenizer st = new StringTokenizer(s, " ");

        for (int i = 0; i < pattern.length(); ++i) {
            if (!st.hasMoreTokens()) return false;

            char ch = pattern.charAt(i);
            String str = st.nextToken();

            if (match.containsKey(ch)) {
                if (!match.get(ch).equals(str)) return false;
            } else {
                if (match.containsValue(str)) return false;
                match.put(ch, str);
            }
        }
        if (st.hasMoreTokens()) return false;


        return true;
    }
}
```
