/*
 * 1. 완전탐색으로 벽을 세울 3곳 정하기
 * 2. bfs로 바이러스 확산하기
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {

	static int n, m, max;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 3곳에 벽 세우기
		for (int x1 = 0; x1 < n; ++x1) { // 벽1
			for (int y1 = 0; y1 < m; ++y1) {
				if(map[x1][y1] != 0) continue;
				for (int x2 = 0; x2 < n; ++x2) { // 벽2
					for (int y2 = 0; y2 < m; ++y2) {
						if(map[x2][y2] != 0) continue;
						if(x1 == x2 && y1 == y2) continue;
						for (int x3 = 0; x3 < n; ++x3) { // 벽3
							for (int y3 = 0; y3 < m; ++y3) {
								if(map[x3][y3] != 0) continue;
								if(x1 == x3 && y1 == y3) continue;
								if(x2 == x3 && y2 == y3) continue;
								
								map[x1][y1] = 1;
								map[x2][y2] = 1;
								map[x3][y3] = 1;
								
								Queue<int[]> q = new ArrayDeque<int[]>();
								int[][] map2 = new int[n][m];
								int safe = 0;
								for (int i = 0; i < n; ++i) {
									for (int j = 0; j < m; ++j) {
										map2[i][j] = map[i][j];
										if (map[i][j] == 2) q.offer(new int[] { i, j });
										if(map[i][j] == 0) safe += 1;
									}
								}
								bfs(map2, q, safe);
								
								map[x1][y1] = 0;
								map[x2][y2] = 0;
								map[x3][y3] = 0;
							}
						}
					}
				}
			}
		}
		System.out.println(max);
		br.close();
	}

	private static void bfs(int[][] map2, Queue<int[]> q, int safe) {
		
		while(!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.poll()[1];

			for (int dir = 0; dir < 4; ++dir) {
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위 벗어남
				if(map2[nx][ny] == 1 || map2[nx][ny] == 2) continue; // 벽이 있거나 이미 바이러스가 있음
				
				map2[nx][ny] = 2;
				q.offer(new int[] {nx, ny});
				safe -= 1;
			}
		}
		
		if(safe > max) max = safe;
	}

}
