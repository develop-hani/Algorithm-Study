/*
 * bfs를 이용하여 가장 자리에서 가까운 치즈들을 표시하며 탐색하였다.
 * 치즈가 녹느데 걸리는 시간이 짧은 것부터 살펴보아야하므로 우선순위 큐를 이용하였다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main_2369_치즈 {

	static int n, m;
	static int[][] map;
	static int time;
	
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Point implements Comparable<Point>{
		int x, y, hour;

		public Point() {
			super();
		}

		public Point(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.hour = w;
		}

		@Override
		public int compareTo(Point o) {
			return this.hour - o.hour;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		int cheese = 0;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					++cheese;
			}
		}

		int lastCheese = bfs(cheese);

		sb.append(time).append("\n").append(lastCheese).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int bfs(int totalCheese) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[n][m];
		int leftCheese = totalCheese;
		
		// 가장자리 큐에 넣기
		for (int i = 0; i < m; ++i) {
			pq.offer(new Point(0, i, 0));
			pq.offer(new Point(n - 1, i, 0));
			visited[0][i] = true;
			visited[n - 1][i] = true;
		}
		for (int i = 1; i < n - 1; ++i) {
			pq.offer(new Point(i, 0, 0));
			pq.offer(new Point(i, m - 1, 0));
			visited[i][0] = true;
			visited[i][m - 1] = true;
		}
		
		while(!pq.isEmpty()) {
			Point curp = pq.poll();
			if(curp.hour > time) { // 다음 단계(녹는데 한 시간이 더 걸리는 경우)로 넘어감
				time = curp.hour;
				if(totalCheese != 0)leftCheese = totalCheese;
			}
			
			for(int dir = 0; dir < 4; ++dir) {
				int nx = curp.x + dx[dir];
				int ny = curp.y + dy[dir];
				int hour = curp.hour;
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				if (map[nx][ny] == 1) { // 치즈가 있음
					--totalCheese;
					pq.offer(new Point(nx, ny, hour + 1));
				} else { // 치즈가 없음
					pq.offer(new Point(nx, ny, hour));
				}
			}
		}
		return leftCheese;
	}
}