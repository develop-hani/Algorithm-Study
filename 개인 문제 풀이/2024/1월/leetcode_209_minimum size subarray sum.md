# leetcode 209 minimum size subarray sum

[leetcode 209 minimum size subarray sum](https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150)

### 🤔 문제 이해하기

- 양의 정수로 이루어진 배열 nums와 양의 정수 target이 주어진다.
- nums의 subarray 중 subarray의 합이 target을 넘는 배열의 길이 최솟값을 구하라.

### ⭐ 알고리즘

- 투 포인터

### 💻 문제를 해결한 코드

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;

        int left = 0, right = 0;
        int sum = nums[0];
        while (left <= right) {
            if (sum < target) {
                if (right == nums.length - 1)
                    break;
                sum += nums[++right];
            } else {
                len = Math.min(len, right - left + 1);
                sum -= nums[left++];
            }
        }

        return len < Integer.MAX_VALUE ? len : 0;
    }
}
```
