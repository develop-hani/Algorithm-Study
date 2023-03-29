/*
 * DP에 차원을 하나 더해 말처럼 움직인 횟수를 셌다.
 * dp[i][j][k]는 [i][j]에 k번 말처럼 움직여서 온 것
 * 
 * 움직임의 최소횟수를 구하는 문제이니 BFS로 풀었다.
 */
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {

	static int k, r, c;
	static boolean[][] map;
	static int[][][] dp;
	static int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 },
			{ 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new boolean[r][c];
		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; ++j) {
				if(Integer.parseInt(st.nextToken()) == 1) map[i][j] = true;
			}
		}

		dp = new int[r][c][k + 1];

		// 로직
		if (r == 1 && c == 1 && !map[0][0]) { // 시작점과 끝 점이 같은 경우
			System.out.println(0);
			return;
		}
		bfs();

		// 출력
		int min = 9999999;
		for (int i = 0; i <= k; ++i) {
			if(dp[r - 1][c - 1][i] == 0) continue;
			min = Math.min(min,dp[r - 1][c - 1][i]);
		}
		System.out.println(min == 9999999 ? -1 : min);

		br.close();

	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		dp[0][0][0] = 0;
		map[0][0] = true;
		q.offer(new int[] { 0, 0, 0, 0 }); // 0: x좌표, 1: y좌표, 2: 현재까지 이동 횟수, 3: 말처럼 움직인 횟수

		while (!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			int cstep = q.peek()[2];
			int chorse = q.poll()[3];

			for (int dir = 0; dir < d.length; ++dir) {
				if (chorse >= k && dir > 3) continue; // 더 이상 말처럼 못 움직임

				int nx = cx + d[dir][0];
				int ny = cy + d[dir][1];

				if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue; // 범위를 벗어난 경우
				if (map[nx][ny]) continue; // 장애물이 있는 경우

				if (dir < 4) { // 사방으로 이동
					if(dp[nx][ny][chorse] > 0 || (nx == 0 && ny == 0)) continue; // 이미 같은 루틴을 온 적이 있음
					dp[nx][ny][chorse] = cstep + 1;
					q.offer(new int[] { nx, ny, cstep + 1, chorse });
				} else { // 말처럼 이동
					if(dp[nx][ny][chorse + 1] > 0 || (nx ==0 && ny==0)) continue; // 이미 같은 루틴을 온 적이 있음
					dp[nx][ny][chorse + 1] = cstep + 1;
					q.offer(new int[] { nx, ny, cstep + 1, chorse + 1 });
				}
			}
		}
	}

}
