# leetcode 205 isomorphic strings

[leetcode 205 isomorphic strings](https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150)

### 🤔 문제 이해하기

- string s와 t가 isomorphic한지 파악하라.
- isomorphic하다는 것은 s의 문자의 모든 문자가 t의 다른 문자로 대체되어야 하며 문자의 순서는 유지되야 하는 것을 말한다.

### ⭐ 알고리즘

- 자료구조

### 📖 스토리 라인

- s의 특정 문자에 매칭된 t문자가 있는지 파악한다.
- t의 특정 문자가 매칭된 s 문자가 있는지 파악한다.
- 둘 다 없다면 s와 t의 문자를 매칭한다.

### 💻 문제를 해결한 코드

s -> t, t -> s로 matching 되는지 파악하는 map을 2개 사용하지 않고, `containsValue()`를 이용하여 파악했더니 실행속도가 개선됐다.

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> match = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);

            if (match.containsKey(sCh)) {
                if (!(match.get(sCh) == tCh)) {
                    return false;
                }
            } else {
                if (match.containsValue(tCh)) {
                    return false;
                }
                match.put(sCh, tCh);
            }
        }

        return true;
    }
}
```
