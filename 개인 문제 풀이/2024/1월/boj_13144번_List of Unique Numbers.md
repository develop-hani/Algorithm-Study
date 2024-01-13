# BOJ 13144번 List of Unique Numbers

[BOJ 13144번 List of Unique Numbers](https://www.acmicpc.net/problem/13144)

### 🤔 문제 이해하기

- 길이가 N인 수열이 있다.
- 수열에서 연속한 1개 이상의 수를 뽑을 때, 같은 수가 여러 번 등장하지 않는 경우의 수를 구하라.

### ⭐ 알고리즘

- 투포인터

### 💭 생각해볼 점

**N ≤ 1,000,000** 이라는 점에 주의하자!

- 이중 for문을 통해 brute force하게 문제를 푼다면 O(N²)이 소요된다 ⇒ 시간 초과
- 수열의 1,000,000개의 수가 모두 다르다면 조건에 맞는 부분 수열의 개수는 int 범위를 초과한다.

### 📖 스토리 라인

`1 2 3 1 2`라는 수열이 있을 때,

1. 0번 째 숫자인 1부터 시작하는 수열의 개수를 찾는다.
   - `1` / `1 2` / `1 2 3`
   - 이 떄 left = 0, right = 3으로 조건에 만족하는 수열의 개수는 3개이다.
2. 1번 째 숫자인 2부터 시작하는 수열의 개수를 찾는다.
   - `2` / `2 3` / `2 3 1`
   - 이 떄 left = 1, right = 4으로 조건에 만족하는 수열의 개수는 3개이다.
3. .............

### 💻 문제를 해결한 코드

```java
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        readData();
        long ans = countArrays();
        writeData(ans);
    }

    // 투포인터로 중복된 수가 없는 수열의 개수를 세기
    private static long countArrays() {
        long cnt = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(nums[0]);
        int left = 0, right = 1;

        while (left < N) { // left번째 수로 시작하는 수열의 수 구하기
            while (right < N && !visited.contains(nums[right])) {
                visited.add(nums[right++]); // left에서 시작하는 수열에서 중복이 없을 때까지 right 중가
            }
            cnt += right - left;
            visited.remove(nums[left++]);

        }
        return cnt;
    }

    private static void readData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
    }

    private static void writeData(long ans) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.format("%d\n", ans));
        bw.flush();
        bw.close();
    }

}
```
