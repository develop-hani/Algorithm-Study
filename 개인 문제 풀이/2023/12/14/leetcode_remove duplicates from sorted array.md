# LEETCODE Remove duplicates from sorted array

[LEETCODE Remove duplicates from sorted array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150)

### 🤔 문제 이해하기

1. 오름차순으로 정렬된 배열이 있다.
2. 중복이 없도록 배열에 저장하고 저장된 숫자의 수를 반환하라

O(n)에 문제를 해결할 수 있도록 변화된 숫자를 저장하는 변수 change를 두었다.

### 💻 문제를 해결한 코드

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int change = 1;
        int before = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (before != nums[i]) {
                nums[change++] = nums[i];
            }
            before = nums[i];
        }
        return change;
    }
}
```
