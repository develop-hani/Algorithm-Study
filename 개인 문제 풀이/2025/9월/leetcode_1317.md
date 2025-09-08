# LeetCode 1317 Convert Integer to the Sum of Two No-Zero Integers

[LeetCode 1317 Convert Integer to the Sum of Two No-Zero Integers](https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/?envType=daily-question&envId=2025-09-08)

### 🤔 문제 이해하기
- n 이 주어진다.
- 더해서 n이 되는 두 수 a, b를 구한다.
- 단 a, b에는 0이 포함되어있으면 안 된다.

### 💻 문제를 해결한 코드
0이 포함되어 있으면 안된다는 걸 어떻게 풀까 고민하다가 수학적으로 다가가기로 했다.
10으로 나누어 떨어지는 확인하는 방법 외에도 냅다 숫자를 문자열로 바꿔서 0을 포함하는 지 판단하는 방법도 있겠다.

```java
String.valueOf(A).contains("0");
```

시간 복잡도: N * log(N)


```java
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a <= n / 2; ++a) {
            int b = n - a;
            if (isNoZeroInteger(a) && isNoZeroInteger(b)) {
                return new int[]{a, b};
            }
        }
        return null;
    }

    private boolean isNoZeroInteger(int num) {
        while (num >= 10) {
            if (num % 10 == 0) return false;
            else num /= 10;
        }
        return true;
    }
}
```
