# Leetcode 27번 Remove Element

[# Leetcode 27번 Remove Element
](https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150)

### 🤔 문제 이해하기

- 배열 nums에서 원소의 값이 val과 같지 않은 원소의 개수 k를 찾고
- nums의 0~k번 째 인덱스까지 val과 같지 않은 값으로 채워라

### 💻 문제를 해결한 코드

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                swap(nums, cnt, i);
                cnt += 1;
            }
        }
        return cnt;
    }

    private void swap (int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
```
