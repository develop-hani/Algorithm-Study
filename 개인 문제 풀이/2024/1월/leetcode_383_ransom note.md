# leetcode 383 ransom note

[leetcode 383 ransom note](https://leetcode.com/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150)

### 🤔 문제 이해하기

- ransomNote와 magazeine이라는 2개의 문자열이 있다.
- magazine의 문자들을 이용하여 ransomNote를 구성할 수 있는지 여부를 파악하라.

### ⭐ 알고리즘

- 구현

### 📖 스토리 라인

1. magazine에 들어있는 각 알파벳의 개수를 센다.
2. 센 알파벳으로 ransomNote를 구성할 수 있는지 파악한다.

### 💻 문제를 해결한 코드

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];

        // count how many times each alphabet appears in string magazine
        for (int i = 0; i < magazine.length(); ++i) {
            ++cnt[getOrder(magazine.charAt(i))];
        }

        for (int i = 0; i < ransomNote.length(); ++i) {
            if (--cnt[getOrder(ransomNote.charAt(i))] < 0) {
                return false;
            }
        }

        return true;
    }

    // Return the order of a character
    private static int getOrder(char ch) {
        return ch - 'a';
    }
}
```
