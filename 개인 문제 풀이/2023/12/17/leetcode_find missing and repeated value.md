# Leetcode contest find missing and repeated value

[Leetcode contest find missing and repeated value](https://leetcode.com/problems/find-missing-and-repeated-values/)

### 🤔 문제 이해하기

1. n x n 크기의 배열이 있다.
2. 배열에는 [1, n2] 범위의 수가 있다.
3. 배열에서 반복되는 숫자와 나타나지 않은 숫자를 찾아라

### 💻 문제를 해결한 코드

```java
class Solution {

    static int n;
    static boolean visited[];

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        n = grid.length;
        visited = new boolean[n * n + 1];

        int repeated = findRepeated(grid);
        int missing = findMissing();

        return new int[] {repeated, missing};
    }

    private static int findRepeated(int[][] grid) {
        int repeated = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int num = grid[i][j];
                if (visited[num]) repeated = Wnum;
                else visited[num] = true;
            }
        }
        return repeated;
    }

    private static int findMissing() {
        for (int i = 1; i <= n * n; ++i) {
            if (!visited[i]) return i;
        }

        return -1;
    }
}
```
