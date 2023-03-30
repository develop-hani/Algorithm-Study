/*
 * dfs + backtracking
 * 순회하는데 필요한 최소 비용을 구하는 문제로 dfs로 접근했다.
 * 항상 순회가 되는 경우가 주어지니, 시작점을 항상 0번 도시로 설정했다.
 * 도착점 역시 항상 0번 도시라는 것에 주의하자.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {

	static int n, w[][];
	static boolean[] visited;
	static int minCost = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		w = new int[n][n];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n];

		dfs(0, 0, 0);
		System.out.println(minCost);

		br.close();
	}

	// cur: 현재 방문 중인 도시, cnt: 현재까지 방문한 도시의 수, cost: 현재까지 들인 비용
	private static void dfs(int cur, int cnt, int cost) {
		if (cnt == n) {
			if (cur == 0) {
				if (cost < minCost) minCost = cost;
			}
			return;
		}

		for (int i = 0; i < n; ++i) {
			if (w[cur][i] == 0) continue; // 갈 수 없는 경우
			if (visited[i]) continue; // 이미 방문한 도시
			if (cost + w[cur][i] > minCost) continue; // 최소비용보다 더 많은 비용이 필요한 경우

			visited[i] = true;
			dfs(i, cnt + 1, cost + w[cur][i]);
			visited[i] = false;
		}
	}

}
