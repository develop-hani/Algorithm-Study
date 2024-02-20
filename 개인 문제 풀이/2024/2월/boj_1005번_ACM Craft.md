# BOJ 1005번 ACM Craft

[BOJ 1005번 ACM Craft](https://www.acmicpc.net/problem/1005)

### 🤔 문제 이해하기

- n개의 건물이 있고 각 건물을 짓는데는 시간이 걸린다.
- 건물을 짓는 순서가 주어지고 이전 건물이 모두 지어진 경우에만 다음 건물을 지을 수 있다.
- w번째 건물이 모두 지어지는 데 걸리는 시간을 구하라.

### ⭐ 알고리즘

- 위상정렬
- 다이나믹 프로그래밍

### 📖 스토리 라인

- 이전 건물이 없는 (indegree가 0인) 건물부터 차례로 건물을 지어간다.

### 💻 문제를 해결한 코드

```java
import java.io.*;
import java.util.*;

public class Main {

    static int n, k, w; // n: 건물의 수, k: 건물 관계의 수, w: 목표 건물
    static int[] time; // 해당 건물을 짓는데 걸리는 시간
    static List<Integer>[] order; // 현재 건물 다음에 지어야 하는 건물
    static int[] indgree; // 현재 건물을 짓기 직전에 지어야하는 건물의 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        while (--TC > -1) {
            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            time = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            indgree = new int[n + 1];
            order = new LinkedList[n + 1];
            for (int i = 0; i < k; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                int pre = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());
                if (order[pre] == null) order[pre] = new LinkedList<>();

                order[pre].add(next);
                indgree[next] += 1;
            }

            w = Integer.parseInt(br.readLine());

            // 로직
            int ans = build();

            // 출력
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 현재 건물을 짓기 위해 필요한 시간
    private static int build() {
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[n + 1];

        // 시작 건물 큐에 넣기
        for (int i = 1; i <= n; ++i) {
            res[i] = time[i];
            if (indgree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (order[cur] == null) continue;
            for (int prev : order[cur]) {
                res[prev] = Math.max(res[prev], res[cur] + time[prev]); // 이전 건물이 다 올라가야 지을 수 있음
                indgree[prev] -= 1;

                if (indgree[prev] == 0) q.offer(prev);
            }
        }
        return res[w];
    }

}
```
