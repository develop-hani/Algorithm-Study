/*
 * 1. 각 섬을 찾아 번호를 부여한다: dfs
 * 2. 섬을 잇는 모든 다리를 파악한다
 * 3. 모든 섬을 잇는 다리 길이의 최솟값을 구한다.: kruskal
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {

	static int n, m;
	static int[] p;
	static int[][] map, islands;
	static PriorityQueue<Bridge> pq = new PriorityQueue<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Bridge implements Comparable<Bridge> {
		int from, to, cost;

		public Bridge() {
			super();
		}

		public Bridge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bridge o) {
			return this.cost - o.cost;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 로직
		int islandCnt = numberIsland(); // 섬을 찾고 번호 붙이기
		buildBridge(islandCnt); // 섬을 잇는 모든 다리 파악하기
		int ans = kruskal(islandCnt); // 모든 섬을 잇는 다리 길이의 최솟값 구하기: kruskal

		// 출력
		sb.append(ans > 0 ? ans : -1).append("\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int numberIsland() {
		islands = new int[n][m];
		int no = 1;

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (map[i][j] == 0) { // 바다라면
					islands[i][j] = -1;
					continue;
				}

				if (islands[i][j] > 0)
					continue; // 이미 번호가 부여된 섬이라면

				findIsland(i, j, no); // 연결된 땅에 같은 섬 번호 붙이기
				++no;
			}
		}
		return no;
	}

	private static void findIsland(int x, int y, int no) {
		islands[x][y] = no;

		for (int dir = 0; dir < 4; ++dir) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;
			if (map[nx][ny] == 0 || islands[nx][ny] > 0)
				continue;
			if (map[nx][ny] == 1)
				findIsland(nx, ny, no);
		}
	}

	private static void buildBridge(int islandCnt) {
		int island1, island2;
		int[][] bridges = new int[islandCnt][islandCnt]; // 두 섬을 잇는 다리 길이의 최소값 저장
		
		// 가로 다리
		for (int i = 0; i < n; ++i) {
			island1 = -1; island2 = -1;
			for (int j = 0; j < m; ++j) {
				if(islands[i][j] == -1) continue;
				
				// 왼쪽에 있는 섬이 island1, 오른쪽에 있는 섬이 island2
				if(j != 0 && (islands[i][j - 1] ^ islands[i][j]) != 0) island2 = j;
				bridgeCraftVerti(island1, island2, i, bridges);
				if(j != m - 1 && (islands[i][j] ^ islands[i][j + 1]) != 0) island1 = j;
				bridgeCraftVerti(island1, island2, i, bridges);
			}
		}
		
		// 세로 다리
		for (int j = 0; j < m; ++j) {
			island1 = -1;
			island2 = -1;
			for (int i = 0; i < n; ++i) {
				if (islands[i][j] == -1) continue;

				// 위쪽 있는 섬이 island1, 아래쪽 있는 섬이 island2
				if (i != 0 && (islands[i - 1][j] ^ islands[i][j]) != 0) island2 = i;
				bridgeCraftHori(island1, island2, j, bridges);
				if (i != n - 1 && (islands[i][j] ^ islands[i + 1][j]) != 0) island1 = i;
				bridgeCraftHori(island1, island2, j, bridges);
			}
		}
		
		// 만들 수 있는 다리 pq에 넣기
		for(int i = 1; i < islandCnt - 1; ++ i) {
			for (int j = i + 1; j < islandCnt; ++j) {
				if(bridges[i][j] > 0) {
					pq.offer(new Bridge(i, j, bridges[i][j]));
				}
			}
		}
	}
	
	private static void bridgeCraftVerti(int island1, int island2, int i, int[][] bridges) {
		if(island1 != -1 && island2 != -1 && islands[i][island1] != islands[i][island2] && island2 - island1 > 2) {
			int sIsland = Math.min(islands[i][island1], islands[i][island2]); // 두 섬 중 번호가 더 작은 섬
			int bIsland = Math.max(islands[i][island1], islands[i][island2]); // 두 섬 중 번호가 더 큰 섬
			if(bridges[sIsland][bIsland] == 0) {
				bridges[sIsland][bIsland] = island2 - island1 - 1;
			} else {
				bridges[sIsland][bIsland] = Math.min(bridges[sIsland][bIsland], island2 - island1 - 1);
			}
		}
	}

	private static void bridgeCraftHori(int island1, int island2, int j, int[][] bridges) {
		if (island1 != -1 && island2 != -1 && islands[island1][j] != islands[island2][j] && island2 - island1 > 2) { // 다리를 건설할 수 있다면
			int sIsland = Math.min(islands[island1][j], islands[island2][j]); // 두 섬 중 번호가 더 작은 섬
			int bIsland = Math.max(islands[island1][j], islands[island2][j]); // 두 섬 중 번호가 더 큰 섬
			if (bridges[sIsland][bIsland] == 0) {
				bridges[sIsland][bIsland] = island2 - island1 - 1;
			} else {
				bridges[sIsland][bIsland] = Math.min(bridges[sIsland][bIsland], island2 - island1 - 1);
			}
		}
	}

	private static int kruskal(int islandCnt) {
		int bridgelen = 0;
		makeSet(islandCnt);

		while (!pq.isEmpty()) {
			Bridge b = pq.poll();
			if (union(b.from, b.to)) {
				bridgelen += b.cost;
			}
		}
		
		for(int i = 2; i < p.length; ++i) {
			if(union(1, i)) return 0; // 아직 union 할 수 있는 게 남아 있다면 모든 섬이 연결되진 않은 것
		}
		
		return bridgelen;
	}
	
	
	static void makeSet(int cnt) {
		p = new int[cnt];
		for(int i = 0; i < cnt; ++i) {
			p[i] = i;
		}
	}
	
	
	static int find(int x) {
		if (p[x] == x) return x;
		return p[x] = find(p[x]);
	}
	
	static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
			
		if(xRoot == yRoot) return false;
		p[yRoot] = p[xRoot];
		return true;
	}
}

/*
 [반례모음]
https://www.acmicpc.net/board/view/63536
*/
