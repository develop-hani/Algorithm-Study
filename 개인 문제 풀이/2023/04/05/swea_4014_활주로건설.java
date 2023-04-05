/*
 * 가로 방향, 세로 방향 활주로를 나누어
 * 활주로를 건설할 수 없는 조건들을 배제하며 구현하였다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			int[][] map = new int[n][n];
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append(String.format("#%d %d\n", tc, solve(n, x, map)));
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int solve(int n, int m, int[][] map) {
		int cnt = 0;

		// 가로 방향 활주로
		for (int i = 0; i < n; ++i) {
			boolean runway = true; // 활주로 건설
			boolean step = false; // 경사로 건설 중
			int cons = 1; // 연속적인 부분의 길이
			for (int j = 1; j < n; ++j) {
				if (map[i][j - 1] == map[i][j]) { // 이전 높이 == 현재 높이
					cons += 1;
					if(step && cons == m) { // 경사로 하나 완성
						step = false;
						cons = 0;
					}
					if(j == n - 1 && step && cons < m) runway = false; // 끝부분까지 경사로를 짓는 중
				}
				else if (map[i][j - 1] == map[i][j] + 1) { // 이전 높이 > 현재 높이
					cons = 1;
					if(step || j == n-1) runway = false; // 경사로 짓는 중인데 하나 더 짓거나, 끝부분에서 높이 차 발생
					step = true; // 경사로 짓기 시작
				} else if (map[i][j - 1] == map[i][j] - 1) { // 이전 높이 < 현재 높이
					if(step || cons < m) runway = false; // 이전에 경사로를 지을 수 없는 경우
					cons = 1;
				} else {
					runway = false;
				}
				
				if(!runway) break;
			}
			if(runway) {
//				System.out.println(i);
				++cnt;
			}
		}

//		System.out.println("==========");
		
		// 세로 방향 활주로
		for (int j = 0; j < n; ++j) {
			boolean runway = true; // 활주로 건설
			boolean step = false; // 높이 차이 발생 여부
			int cons = 1; // 연속적인 부분의 길이
			for (int i = 1; i < n; ++i) {
				if (map[i - 1][j] == map[i][j]) { // 이전 높이 == 현재 높이
					cons += 1;
					if(step && cons == m) {
						step = false;
						cons = 0;
					}
					if(i == n - 1 && step && cons < m) runway = false;
				}
				else if (map[i - 1][j] == map[i][j] + 1) { // 이전 높이 > 현재 높이
					cons = 1;
					if(step || i == n-1) runway = false;
					step = true;
				} else if (map[i - 1][j] == map[i][j] - 1) { // 이전 높이 < 현재 높이
					if(step || cons < m) runway = false;
					cons = 1;
				} else {
					runway = false;
				}
				
				if(!runway) break;
			}
			if(runway) {
//				System.out.println(j);
				++cnt;
			}
		}

		return cnt;
	}
}

/*
40/50 반례
1
6 2
3 3 2 2 2 3
3 3 2 2 2 3
3 3 2 2 2 3
3 3 2 2 2 3
3 3 2 2 2 3
3 3 2 2 2 3
 */
