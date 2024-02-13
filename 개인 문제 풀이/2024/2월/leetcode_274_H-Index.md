# leetcode 274 H-Index

[leetcode 274 H-Index](https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150)

### 🤔 문제 이해하기

- 연구원이 작성한 논문의 인용 횟수가 적힌 citations 배열이 있다.
- 해당 연구원 논문의 h-index를 찾아라.
- h-index는 최소 h번 인용된 논문을 적어도 h번 발표한 h의 최대값을 말한다.

### ⭐ 알고리즘

- 정렬
- counting sort

### 💻 문제를 해결한 코드

#### Arrays의 정렬을 이용한 풀이

- Time Complextity: O(nlog(n))
- Space Complexity: O(1)
- Runtime: 2ms
- Memrouy: 41.63MB

```java
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int idx = 0;

        Arrays.sort(citations);
        for (int i = 0; i < len; ++i) {
            int min = citations[i]; // 인용횟수
            int cnt = len - i; // 해당 인용횟수보다 같거나 많게 인용한 책의 수

            idx = Math.max(Math.min(min, cnt), idx);
            if (min > cnt) break;
        }

        return idx;
    }
}
```

#### Counting sort의 개념을 이용하자

- Time Complextity: O(n)
- Space Complexity: O(n)
- Runtime: 0ms
- Memrouy: 41.73MB

정렬이라고 볼 수 있을까?? </br>
실제 데이터를 정렬하는 것이 아닌 데이터로부터 추출한 데이터를 이용하는 방법</br>

</br>

- 각 논문의 인용 횟수 or 논문 발표 횟수 저장
- i번 이상 발표된 논문이 몇 개인지 파악

```java
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int count[] = new int[len + 2]; // i번 이상 발표된 논문이 i개

        // counting papers for each citation number
        for (int c : citations) {
            count[Math.min(c, len)] += 1;
        }

        // finding the h-index
        int h;
        for (h = len; h > 0; --h) {
            count[h] += count[h + 1];
            if (count[h] >= h) break;
        }
        return h;
    }
}
```
