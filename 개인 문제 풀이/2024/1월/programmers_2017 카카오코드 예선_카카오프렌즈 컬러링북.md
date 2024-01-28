# programmers / 2017 카카오코드 예선 / 카카오프렌즈 컬러링북

[programmers / 2017 카카오코드 예선 / 카카오프렌즈 컬러링북](https://school.programmers.co.kr/learn/courses/30/lessons/1829?language=java)

### 🤔 문제 이해하기

- mxn 크기의 그림이 있다.
- 그림에서 몇 개의 영역이 있는지 구하고 가장 큰 영역의 넓이는 얼마인지 구하라.

### ⭐ 알고리즘

- dfs

### 📖 스토리 라인

- 색칠되어 있지만 방문하지 않은 점이 있다면 해당 점을 기점으로 dfs를 시작한다.
- 연결된 영역의 크기를 구하며 방문 여부를 체크한다.

### 💻 문제를 해결한 코드

```java
class Solution {

    static int cnt;
    static boolean[][] visited;
    static int[][] dd = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상,하,좌,우

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (picture[i][j] > 0 && !visited[i][j]) {
                    numberOfArea += 1;

                    cnt = 0;
                    dfs(i, j, picture);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                }
            }
        }

        int[] answer = {numberOfArea, maxSizeOfOneArea};
        return answer;
    }

    // dfs로 연결된 부분의 크기 찾기
    private static void dfs(int r, int c, int[][] picture) {
        visited[r][c] = true;
        ++cnt;
        for (int dir = 0; dir < 4; ++dir) {
            int nr = r + dd[dir][0];
            int nc = c + dd[dir][1];

            if (!inPicture(nr, nc)) continue; // 범위를 벗어난 경우
            if (visited[nr][nc]) continue; // 이미 방문한 곳
            if (picture[r][c] != picture[nr][nc]) continue; // 색상이 다른 곳

            dfs(nr, nc, picture);
        }
    }

    // 주어진 칸이 그림 내부에 있는지 확인
    private static boolean inPicture(int r, int c) {
        if (r < 0 || c < 0 || r >= visited.length || c >= visited[0].length) return false;
        return true;
    }
}
```
