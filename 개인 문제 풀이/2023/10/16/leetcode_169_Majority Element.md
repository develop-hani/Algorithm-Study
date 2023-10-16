# Leetcode 169번 Majority Element

[Leetcode 169번 Majority Element](https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150)

### 🤔 문제 이해하기

- 크기가 n인 배열이 주어질 때, 해당 배열에서 n/2번보다 많이 등장하는 원소를 찾아라

### ⭐ 알고리즘

- 정렬

### 📖 스토리 라인

- 항상 n/2번보다 많이 등장하는 원소가 있다면, 그 값은 배열을 정렬하였을 때 배열의 n/2번 째 원소일 것이다.

### 💻 문제를 해결한 코드

```java
import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
```
