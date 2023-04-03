/*
 * bfs를 이용하여 해결하였다.
 * 각 점에서 갈 수 있는 점들을 모두 확인하고 갈 수 있으면 큐에 넣었다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {

	static class Point {
		int x;
		int y;

		public Point() {
			super();
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public boolean canGo(Point p) {
			if (Math.abs(p.x - this.x) + Math.abs(p.y - this.y) <= 1000) return true;
			else return false;
		}
	}
	
	static Queue<Point> q; // 가까운 편의점이나 페스티벌
	static List<Point> list; // 편의점 리스트, 페스티벌 장소
	static Map<Point, Boolean> map; // 방문관리

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		while (--TC >= 0) {
			q = new LinkedList<>();
			list = new ArrayList<>();
			map = new HashMap<>();
			
			int n = Integer.parseInt(br.readLine()); // 편의점 개수

			st = new StringTokenizer(br.readLine(), " "); // 집
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Point home = new Point(x, y);
			q.offer(home);

			for (int i = 0; i < n; ++i) { // 편의점
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				Point conv = new Point(x, y);
				list.add(conv);
				map.put(conv, false);
			}

			st = new StringTokenizer(br.readLine(), " "); // 페스티벌
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Point fest = new Point(x, y);
			list.add(fest);
			map.put(fest, false);

			sb.append(solve(fest) ? "happy\n" : "sad\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean solve(Point fest) {

		while (!q.isEmpty()) {
			Point from = q.poll();
			for (int i = 0; i < list.size(); ++i) {
				Point to = list.get(i);
				if(to.x == from.x && to.y == from.y) continue; // 같은 곳이면 지나가기
				if(map.get(to)) continue; // 이미 방문한 곳이면 지나가기
				
				// 현재 점으로부터 1000m 안에 있으면 갈 수 있음
				if(from.canGo(to)) {
					if(to.x == fest.x && to.y == fest.y) return true;
					map.replace(to, true);
					q.offer(to);
				}
			}
		}

		return false;
	}

}
