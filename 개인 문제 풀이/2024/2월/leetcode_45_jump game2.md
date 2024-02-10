# leetcode 45 Jump Game 2

[leetcode 45 Jump Game 2](https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150)

### 🤔 문제 이해하기

- 양의 정수로 이루어진 배열 n이 있고 현재 0번째 인덱스에 위치하고 있다.
- nums[i]는 현재 위치에서 점프할 수 있는 최대 거리를 나타낸다.
- 마지막 인덱스에 도달하기 위해 점프하기 위한 최소횟를 구하라.

### ⭐ 알고리즘

- 구현
- bfs
  - 최소횟수를 구하는 문제이닌 bfs를 적용할 수 있다는 생각을 왜 못했을까!

### 💻 문제를 해결한 코드

#### 구현

- Time Complexity: O(n<sup>2</sup>)
- Space Complexity: O(n)
  </br>
- RunTime: 39ms
- Memory: 45.93MB

```java
class Solution {
    public int jump(int[] nums) {
        int len = nums.length - 1;
        int[] jump = new int[len + 1];
        Arrays.fill(jump, Integer.MAX_VALUE);
        jump[0] = 0;

        for (int i = 0; i < len; ++i) {
            for (int j = 1; j <= nums[i]; ++j) {
                if (i + j > len) continue; // 길이보다 더 많이 뛰는 경우
                jump[i + j] = Math.min(jump[i] + 1, jump[i + j]);
                if (i + j == len) return jump[len];
            }
        }

        return jump[len];
    }

}
```

#### BFS

- Time Complexity: O(n)
- Space Complexity: O(1)
  </br>
- Runtime: 2ms
- Memory: 45.28MB

```java
class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int end = 0;
        int farest = 0;

        // Implicit BFS
        for (int i = 0; i < nums.length - 1; ++i) {
            farest = Math.max(farest, i + nums[i]); // 뛰었을 때 갈 수 있는 가장 먼 인덱스
            if (farest >= nums.length - 1) { // 마지막 인덱스에 도달 가능하다면
                ++ans;
                break;
            }
            if (i == end) { // 현재 수준에서 갈 수 있는 곳을 모두 방문한 경우
                ++ans;
                end = farest;
            }
        }
        return ans;
    }
}
```
