/*
 * 모든 경로를 통한 최단 거리를 구하는  문제로
 * floyd-warshall 알고리즘을 이용하여 해결하였다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; ++tc) {
			// 입력
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][n];
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (i == j) continue;
					if (arr[i][j] == 0) arr[i][j] = 3000;
				}
			}

			// 출력
			sb.append(String.format("#%d %s\n", tc, solve(n, arr)));
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int solve(int n, int[][] arr) {
		// 최단 경로 구하기
		for (int k = 0; k < n; ++k) {
			for (int i = 0; i < n; ++i) {
				if(i == k) continue;
				for (int j = 0; j < n; ++j) {
					if(j == k || j == i) continue;
					
					arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
				}
			}
		}
		
		int min = 600000;
		for(int i = 0; i < n; ++i) {
			int sum = 0;
			for(int j = 0; j < n; ++j) {
				sum += arr[i][j];
			}
			if(sum < min) min = sum;
		}

		return min;
	}

}
