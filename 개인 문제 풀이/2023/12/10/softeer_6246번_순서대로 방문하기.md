# softeer 6246번 순서대로 방문하기

[softeer 6246번 순서대로 방문하기](https://softeer.ai/practice/6246)

### 🤔 문제 이해하기

1. 빈 칸과 벽으로 이르어진 격자가 있다. (n x n)
2. m개의 칸 순서가 주어질 때, 주어진 순서대로 방문할 수 있는 경로의 개수를 구한다.

※ 2 ≤ n ≤ 4
※ 2 ≤ m ≤ n<sup>2</sup>

### ⭐ 알고리즘

- dfs
  순서대로 탐색해야하므로 dfs를 이용하여 각 칸에 방문하였다.

### 📖 스토리 라인

1. dfs로 각 칸에 방문한다.
   - 방문 여부를 판단하는 visited의 배열에는 각 칸에 방문한 순서를 저장한다.
2. 마지막 칸에 도착했다면 올바른 순서로 칸에 방문하였는지 확인한다.
   다음과 같은 예제가 주어졌을 때
   ```txt
   3 3
   0 0 0
   0 0 0
   0 0 1
   3 1
   1 2
   2 3
   ```
   방문에 성공하였을 때 visited의 경우로는 다음과 같은 경우가 있다.
   ```txt
   3 4 0      3 4 5      0 4 5      0 4 5      5 6 7
   2 5 6      2 0 6      2 3 6      0 3 6      4 3 8
   1 0 0      1 0 0      1 0 0      1 2 0      1 2 0
   ```
   반면 마지막 칸에는 도달했지만 순서대로 방문하는 것에 실패한 경우는 다음과 같다.
   ```txt
   0 0 0      0 0 0
   2 3 4      0 3 4
   1 0 0      1 2 0
   ```

### 💻 문제를 해결한 코드

```java
import java.io.*;
import java.util.*;

public class Main {

  static int n, m;
  static int[][] map;
  static int[][] order;
  static int ans = 0;

  // 상하좌우 순서로 방문
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();

      // 입력
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());

      map = new int[n + 1][n + 1];
      for (int i = 1; i < n + 1; ++i) {
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 1; j < n + 1; ++j) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      order = new int[m][2];
      for (int i = 0; i < m; ++i) {
        st = new StringTokenizer(br.readLine(), " ");
        order[i][0] = Integer.parseInt(st.nextToken());
        order[i][1] = Integer.parseInt(st.nextToken());
      }

      // 로직
      int[][] visited = new int[n + 1][n + 1];
      visited[order[0][0]][order[0][1]] = 1;
      dfs(order[0][0], order[0][1], 1, visited);

      // 출력
      sb.append(ans).append("\n");

      bw.write(sb.toString());
      bw.flush();
      bw.close();
      br.close();
    }

    // 그래프
    // visited에는 각 위치를 방문한 순서 저장
    private static void dfs(int cr, int cc, int depth, int[][] visited) {
      if (cr == order[m - 1][0] && cc == order[m - 1][1]) { // 마지막 장소에 도착했다면
        if (getOrder(visited)) ans += 1; // 순서대로 도착했는 지 확인하기
        return;
      }

      for (int dir = 0; dir < 4; ++dir) {
        int nr = cr + dr[dir];
        int nc = cc + dc[dir];

        if (nr < 1 || nr > n || nc < 1 || nc > n) continue; // 범위를 벗어난 경우
        if (map[nr][nc] > 0) continue; // 벽인 경우
        if (visited[nr][nc] > 0) continue; // 이미 방문한 경우

        visited[nr][nc] = depth + 1;
        dfs(nr, nc, depth + 1, visited);
        visited[nr][nc] = 0;
      }
    }

    // 목표한 순서대로 각 칸을 방문했는지 확인하기
    private static boolean getOrder(int[][] visited) {
      for (int i = 1; i < m; ++i) {
        if (visited[order[i - 1][0]][order[i - 1][1]] > visited[order[i][0]][order[i][1]]) return false;
      }
      return true;
    }

}

```
