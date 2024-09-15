# BOJ 11399번 ATM

[BOJ 11399번 ATM](https://www.acmicpc.net/problem/11399)

### 🤔 문제 이해하기

- n명의 사람이 있다.
- 각 사람이 돈을 인출하는데 걸리는 시간은 p[i]이다.
- 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하라.

### ⭐ 알고리즘

- 정렬
- 그리디

### 📖 스토리 라인

- 대기 시간이 적은 순서대로 정렬한다.
- 각 사람의 대기 시간을 더한다.

### 💻 문제를 해결한 코드

```java
import java.io.*;
import java.util.*;

public class Main {

    static int n; // 대기인 수
    static int[] p; // 현금 인출에 걸리는 시간

    public static void main(String[] args) throws Exception {
        readData();
        int ans = getTime();
        writeData(getTime());
    }

    private static void readData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
    }

    private static int getTime() {
        int sum = 0;

        Arrays.sort(p);
        for (int i = 0; i < n; ++i) {
            sum += p[i] * (n - i);
        }

        return sum;
    }

    private static void writeData(int ans) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
```
