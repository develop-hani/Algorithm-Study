import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {
	
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1;; ++tc) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;

			int[][] map = new int[n][n];
			for (int i = 0; i < n; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append(String.format("Problem %d: %d\n", tc, dijkstra(n, map)));
		}

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	private static int dijkstra(int n, int[][] map) {
		int[][] dist = new int[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] p1, int[] p2) -> {
			return p1[2] - p2[2];
		});
		pq.offer(new int[] { 0, 0, map[0][0]}); // 0: x좌표, 1: y좌표, 2: 도둑루피
		dist[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if (cur[0] == n - 1 && cur[1] == n - 1) break;
			
			for(int dir = 0; dir<4;++dir) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if(dist[nx][ny] < Integer.MAX_VALUE) continue; // 이미 방문한 정점
				
				pq.offer(new int[] {nx, ny, cur[2] + map[nx][ny]});
				dist[nx][ny] = cur[2] + map[nx][ny];
			}
		}

		return dist[n - 1][n - 1];
	}

}
