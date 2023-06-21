// Floyd-Warshall 알고리즘을 통해 모든 경로를 통하는 최단 거리를 구한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, dist[][];
    static final int MAX = 100_000_005;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 입력
        n = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            Arrays.fill(dist[i], MAX);
            dist[i][i] = 0;
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[from][to] = Math.min(cost, dist[from][to]);
        }

        // 로직
        FloydWarshall();

        // 출력
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if(dist[i][j] < MAX) sb.append(dist[i][j]).append(" ");
                else sb.append(0).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void FloydWarshall() {
        for (int k = 1; k <= n; ++k) {
            for (int i = 1; i <= n; ++i) {
                if (i == k) continue;
                for (int j = 1; j <= n; ++j) {
                    if (j == k || j == i) continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}