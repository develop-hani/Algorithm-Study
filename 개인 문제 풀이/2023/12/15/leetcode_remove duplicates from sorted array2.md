# LEETCODE Remove duplicates from sorted array2

[LEETCODE Remove duplicates from sorted array2](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150)

### 🤔 문제 이해하기

1. 오름차순으로 정렬된 배열이 있다.
2. 하나의 숫자가 최대 2번까지 나올 수 있도록 배열에 저장하고 저장된 숫자의 수를 반환하라

O(n)에 문제를 해결할 수 있도록 변화된 숫자를 저장하는 변수 change를 두었다.

### 💻 문제를 해결한 코드

**직전 수가 몇번 나왔는지 체크하고 저장하는 방법**

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int change = 1;
        int before = nums[0];
        int repeat = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != before) repeat = 0;
            else ++repeat;
            if (!(nums[i] < before) && repeat < 2) nums[change++] = nums[i];
            before = nums[i];
        }
        return change;
    }
}
```

**두번쨰 전의 숫자와 비교하는 방법**

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int change = 0;
        for (int num : nums) {
            if (change < 2 || num > nums[change - 2]) {
                nums[change++] = num;
            }
        }
        return change;
    }
}
```
