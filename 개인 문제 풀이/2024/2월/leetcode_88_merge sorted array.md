# leetcode 88 merge sorted array

[leetcode 88 merge sorted array](https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150)

### 🤔 문제 이해하기

- 정렬된 상태의 두 배열이 존재할 떄, 오름차순으로 합쳐라

### ⭐ 알고리즘

- 구현

### 💻 문제를 해결한 코드

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int idx1 = 0; int idx2 = 0;

        for (int i = 0; i < m + n; ++i) {
            if (idx1 >= m) {
                ans[i] = nums2[idx2++];
                continue;
            }

            if (idx2 >= n) {
                 ans[i] = nums1[idx1++];
                continue;
            }

            ans[i] = (nums1[idx1] < nums2[idx2]) ? nums1[idx1++] : nums2[idx2++];
        }

        // copy ans value to nums1
        for (int i = 0; i < m + n; ++i) {
            nums1[i] = ans[i];
        }
    }
}
```
