# BOJ 15591번 MooTube

[BOJ 15591번 MooTube](https://www.acmicpc.net/problem/15591)

### 🤔 문제 이해하기

- N (N ≤ 5,000)개의 동영상이 있다.
- N - 1개의 연결 구조를 가진다. (연결 구조에는 연결 cost인 usado가 존재한다.)
- 어떤 동영상으로 가는 **경로**가 반드시 하나 **존재**한다.
- 특정 동영상에서 다른 동영상으로의 직접적인 연결이 없다면 **연결 경로 중 usado의 최솟값**을 값으로 한다.

### ⭐ 알고리즘

- BFS
  - n - 1개의 연결이 주어짐 + 연결 경로 반드시 존재 => **사이클 X**
  - 각 USADO를 배열에 기록하면 N <= 5000, 4byte _ 5000 _ 5000 => 메모리 제한
    => BFS로 매 질문마다 추천 동영상의 개수를 세자!

### 📖 스토리 라인

1. 시작 동영상과 연결된 동영상들을 저장한다.
2. 각 질문마다 BFS를 통해 연결된 동영상을 파악한다.

### 💻 문제를 해결한 코드

- BFS 시에 큐에 다음 동영상과 usado의 최솟값을 저장한다.
- **모든 동영상을 탐색**한다.

| 메모리   | 시간   |
| -------- | ------ |
| 300992KB | 2000ms |

```java
import java.io.*;
import java.util.*;

public class Main {

    static int n; // 동영상의 개수
    static List<Node>[] linked;

    static class Node {
        int to;
        int usado;

        public Node(int to, int usado) {
            this.to = to;
            this.usado = usado;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 변수 선언 및 초기화
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken()); // 질문의 개수

        linked = new List[n + 1];
        for (int i = 1; i <= n; ++i) linked[i] = new ArrayList<>();

        // 동영상 간의 연관 관계 받기
        for (int i = 0; i < n - 1; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            linked[from].add(new Node(to, cost));
            linked[to].add(new Node(from, cost));
        }

        // 각 동영상에서 USADO >= k인 연관 동영상의 개수 찾기
        for (int i = 0; i < q; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            sb.append(find(k, from)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // from과 연관된 동영상 중 usado >= k인 동영상의 개수
    static int find(int k, int from) {
        int cnt = 0;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(from, Integer.MAX_VALUE)); // 시작위치에 도달할 때까지 걸리는 값 최대로 두기
        boolean[] visited = new boolean[n + 1];
        visited[from] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.to != from && cur.usado >= k) cnt += 1;

            for (Node next : linked[cur.to]) {
                if (visited[next.to]) continue; // 이미 방문한 곳이면 넘어가기

                int nUsado = next.usado < cur.usado ? next.usado : cur.usado;
                q.add(new Node(next.to, nUsado));
                visited[next.to] = true;
            }
        }
        return cnt;
    }
}

```

### 💻 개선한 코드

- 모든 동영상을 탐색할 필요가 없다.
  만약 특정 경로에서 usado < k인 동영상이 있다면 이와 **연결된 동영상의 usado는 항상 k보다 작다**.
  (**연결 경로 중 usado의 최솟값**을 usado로 하기 때문)

따라서 연결된 경로 중 **usado < k인 경우는 탐색하지 않으면** 실행 시간을 개선할 수 있다.

| 메모리   | 시간   |
| -------- | ------ |
| 287864KB | 1212ms |

```java
import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {

    static int n; // 동영상의 개수
    static List<Node>[] linked;

    static Function<String, Integer> stoi = Integer::parseInt;
    static final String ENTER = "\n";

    static class Node {
        int to;
        int usado;

        public Node(int to, int usado) {
            this.to = to;
            this.usado = usado;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 변수 선언 및 초기화
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = stoi.apply(st.nextToken());
        int q = stoi.apply(st.nextToken()); // 질문의 개수

        linked = new List[n + 1];
        for (int i = 1; i <= n; ++i) linked[i] = new ArrayList<>();

        // 동영상 간의 연관 관계 받기
        for (int i = 0; i < n - 1; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = stoi.apply(st.nextToken());
            int to = stoi.apply(st.nextToken());
            int cost = stoi.apply(st.nextToken());

            linked[from].add(new Node(to, cost));
            linked[to].add(new Node(from, cost));
        }

        // 각 동영상에서 USADO >= k인 연관 동영상의 개수 찾기
        for (int i = 0; i < q; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = stoi.apply(st.nextToken());
            int from = stoi.apply(st.nextToken());
            sb.append(find(k, from)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // from과 연관된 동영상 중 usado >= k인 동영상의 개수
    static int find(int k, int from) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        q.add(from); // 시작위치에 도달할 때까지 걸리는 값 최대로 두기
        visited[from] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Node next : linked[cur]) {
                if (visited[next.to]) continue; // 이미 방문한 곳이면 넘어가기
                if (next.usado < k) continue; // usado가 k보다 작다면 항상 usado보다 작음

                visited[next.to] = true;
                q.add(next.to);
                cnt += 1;
            }
        }
        return cnt;
    }
}
```
