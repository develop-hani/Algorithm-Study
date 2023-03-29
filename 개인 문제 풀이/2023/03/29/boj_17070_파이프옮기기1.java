/*
 * DP
 * pipe 배열은 해당 위치를 파이프의 끝으로 할 수 있는 경우의 수이다.
 * pipe[i][j].hori는 파이프의 시작점이 [i][j-1], 끝점이 [i][j] (-)
 * pipe[i][j].verti는 파이프의 시작점이 [i-1][j], 끝점이 [i][j] (|)
 * pipe[i][j].diag는 파이프의 시작점이 [i-1][j-1], 끝점이 [i][j] (\)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {

	static class Pipe {
		int hori, verti, diag; // 가로, 세로, 대각선

		public Pipe() {
			super();
		}

		public Pipe(int hori, int verti, int diag) {
			super();
			this.hori = hori;
			this.verti = verti;
			this.diag = diag;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] board = new int[n][n];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(board[n-1][n-1] == 1) System.out.println(0); // 도착지점이 벽인 경우
		else System.out.println(solve(n, board));
		
		br.close();
	}

	private static int solve(int n, int[][] board) {
		Pipe[][] pipe = new Pipe[n][n];
		pipe[0][1] = new Pipe(1, 0, 0);

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				// 살펴 볼 필요가 없는 위치
				if(i==0 && j == 1) continue;
				
				if (board[i][j] == 1) continue; // 벽이 있을 떄

				pipe[i][j] = new Pipe();
				// 가로 방향으로 파이프 놓기
				if (j - 1 >= 0 && board[i][j - 1] != 1) pipe[i][j].hori = pipe[i][j - 1].hori + pipe[i][j - 1].diag;
				//세로 방향으로 파이프 놓기
				if (i - 1 >= 0 && board[i - 1][j] != 1) pipe[i][j].verti = pipe[i - 1][j].verti + pipe[i - 1][j].diag;
				// 대각선 방향으로 파이프 놓기
				if(i - 1 < 0 || board[i-1][j] == 1) continue; // 왼쪽에 벽이 있는 경우
				if(j - 1 < 0 || board[i][j-1] == 1) continue; // 위쪽에 벽이 있는 경우
				if (board[i - 1][j - 1] != 1)
					pipe[i][j].diag = pipe[i - 1][j - 1].hori + pipe[i - 1][j - 1].verti + pipe[i - 1][j - 1].diag;
			}
		}

		return pipe[n - 1][n - 1].hori + pipe[n - 1][n - 1].verti + pipe[n - 1][n - 1].diag;
	}

}
