# leetcode merge sorted array

[leetcode merge sorted array]([링크](https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150)https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150)

### 🤔 문제 이해하기
- 오름차순으로 원소가 나열되어 있는 2개의 배열이 주어진다.
- 하나의 배열에 두 배열 원소의 값을 오름차순으로 정렬해라.

### ⭐ 알고리즘
- 구현

### 📖 스토리 라인
1. 앞에서부터 파악해가며 새로운 배열에 두 원소의 값을 오름차순으로 넣는다.

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
