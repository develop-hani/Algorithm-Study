# leetcode 55 Jump Game

[leetcode 55 Jump Game](https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150)

### 🤔 문제 이해하기

- 양의 정수로 이루어진 배열 nums가 주어진다.
- 배열의 첫번째 인덱스에서 시작한다.
- 배열의 각 수는 jump할 수 있는 최대 거리를 나타낸다.
- jump를 반복하여 마지막 인덱스까지 갈 수 있는지 판단하라.

### ⭐ 알고리즘

- 구현

### 📖 스토리 라인

- 갈 수 있는 최대 거리를 나타내는 변수 idx
- 배열을 순차적으로 탐색하면 각 위치에 도달했을 때 어디까지 갈 수 있는지 판단한다.

### 💻 문제를 해결한 코드

- 시간 복잡도: O(n)
- 공간 복잡도: O(1)

```java
class Solution {
    public boolean canJump(int[] nums) {
        int max = nums.length;
        int idx = 0; // 갈 수 있는 최대 인덱스

        for (int i = 0; i < max; ++i) {
            if (i > idx) return false; // 갈 수 없음
            idx = Math.max(idx, i + nums[i]);
            if (idx >= max) return true; // 끝까지 가버림
        }
        return true;
    }
}
```
