/*
 * 고슴도치와 홍수에 대해 각각 bfs를 진행하였다.
 * 문제 조건에 "고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다."고 하므로 이동할 수 있는 각 단계에서
 * 물을 먼저 이동하고 고슴도치를 이동하였다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {

	static int n, m;
	static char[][] map;
	static int[][] visited;
	static Queue<Point> flood = new LinkedList<>();
	static Queue<Point> hedgehog = new LinkedList<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	static class Point {
		int x, y, step;

		public Point() {
			super();
		}

		public Point(int x, int y, int step) {
			super();
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visited = new int[n][m];
		for (int i = 0; i < n; ++i) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; ++j) {
				if (map[i][j] == '*') flood.offer(new Point(i, j, 1));
				else if (map[i][j] == 'S') hedgehog.offer(new Point(i, j, 1));
			}
		}

		int ans = hedgehogMove();
		sb.append(ans > 0 ? ans - 1 : "KAKTUS").append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int hedgehogMove() {
		
		visited[hedgehog.peek().x][hedgehog.peek().y] = 1;

		while (!hedgehog.isEmpty()) {
			if(flood.size() > 0 && flood.peek().step <= hedgehog.peek().step) floodMove(); // 다음 이동
			
			Point cur = hedgehog.poll();
			for(int dir = 0; dir < 4; ++dir) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				int nstep = cur.step + 1;
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (map[nx][ny] == '*' || map[nx][ny] == 'X') continue;
				if (visited[nx][ny] > 0) continue;
				
				if (map[nx][ny] == 'D') return nstep;
				visited[nx][ny] = nstep;
				hedgehog.offer(new Point(nx, ny, nstep));
			}
		}

		return 0;
	}
	
	private static void floodMove() {
		int curStep = flood.peek().step;
		while (!flood.isEmpty()) {
			if(flood.peek().step > curStep) break;
			
			Point cur = flood.poll();
			for(int dir = 0; dir < 4; ++dir) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				int nstep = cur.step + 1;
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (map[nx][ny] == '*' || map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
				
				map[nx][ny] = '*';
				flood.offer(new Point(nx, ny, nstep));
			}
		}
	}

}
