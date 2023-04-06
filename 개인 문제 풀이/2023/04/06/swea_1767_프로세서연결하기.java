/*
 * dfs를 이용하여 각 코어에 대해 사방으로 전선을 깔았다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {

	static class Core {
		int x, y;

		public Core() {
			super();
		}

		public Core(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int n, arr[][];
	static int connectedMax, wireMin;
	static List<Core> core;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; ++tc) {
			// 입력
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			core = new ArrayList<Core>();
			connectedMax = 0;
			wireMin = 5000;
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {
						if(i == 0 || i == n -1 || j == 0 || j == n - 1) continue; // 가장자리에 있는 코어는 전선을 연결할 필요가 없다.
						else core.add(new Core(i, j));
					}
				}
			}

			// 로직
			dfs(0, 0, 0);

			// 출력
			sb.append(String.format("#%d %d\n", tc, wireMin));
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	// cur: 현재 확인 중이 코어, connected: 연결된 코어의 수, len: 현재까지 연결한 전선의 길이
	private static void dfs(int cur, int connected, int len) {
		if (cur == core.size()) {
			if (connected > connectedMax) {
				wireMin = len;
				connectedMax = connected;
			}
			else if (connected == connectedMax) wireMin = Math.min(len, wireMin);
			return;
		}

		for (int dir = 0; dir < 4; ++dir) {
			int curlen = layWire(core.get(cur).x + dx[dir], core.get(cur).y + dy[dir], dir, 0); // 전선 깔기
			if (curlen > 0) { // 전선을 깔 수 있다면, 
				dfs(cur + 1, connected + 1, len + curlen);
				removeWire(core.get(cur).x + dx[dir], core.get(cur).y + dy[dir], dir); // 깔았던 전선 치우기
			} else { // 해당 방향으로 전선을 깔 수 없다면, 
				dfs(cur + 1, connected, len + curlen);
			}
		}

		return;
	}

	// 전선을 깔고, 깔 수 있다면 그 길이 반환
	// x.y: 현재 전선을 깔고 있는 위치, dir: 전선을 깔고 있는 방향
	private static int layWire(int x, int y, int dir, int len) {
		if (x < 0 || x >= n || y < 0 || y >= n) return len;
		if (arr[x][y] > 0) return 0; // 다른 코어나 전선이 이미 깔려있는 경우
		
		arr[x][y] = 2;
		int res = layWire(x + dx[dir], y + dy[dir], dir, len + 1);
		if (res == 0 ) arr[x][y] = 0;
		
		return res;
	}

	// 깔았던 전선 없애기
	private static void removeWire(int x, int y, int dir) {
		if (x < 0 || x >= n || y < 0 || y >= n) return;
		if (arr[x][y] != 2) return; // 전선이 깔려있지 않은 경우
		
		arr[x][y] = 0;
		removeWire(x + dx[dir], y + dy[dir], dir);
	}

}