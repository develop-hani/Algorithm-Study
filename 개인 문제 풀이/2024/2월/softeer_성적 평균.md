# softeer 성적 평균

### 🤔 문제 이해하기

- N명의 학생의 성적이 차례로 주어진다.
- K개의 학생 구간이 주어질 때, 각 구간 학생들의 성적 평균을 구하여라

### ⭐ 알고리즘

- 구현

### 📖 스토리 라인

- 학생 성적의 누적합을 저장한다.

### 💻 문제를 해결한 코드

```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans = new StringBuilder();

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 학생의 수
        int k = Integer.parseInt(st.nextToken()); // 구간의 수

        st = new StringTokenizer(br.readLine(), " ");
        int[] sum = new int[n + 1]; // 학생 성적의 누적합
        for (int i = 1; i < n + 1; ++i) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        // 로직
        int a, b;
        double avg;
        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            avg = (double) (sum[b] - sum[a - 1]) / (b - a + 1);
            ans.append(String.format("%.2f\n", avg));
        }

        bw.write(ans.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
```
