/*
 * 사전순으로 가장 앞에 있는 스도쿠 해답을 구하면 되므로
 * dfs로 가능한 경우를 탐색해 나가며, 해답을 발견한 경우 더 이상 가능한 경우에 대해 탐색해보지 않고 정답을 출력한다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2239_스도쿠 {

	static int[][] sudoku;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		sudoku = new int[9][9];
		for (int i = 0; i < 9; ++i) {
			String input = br.readLine();
			for (int j = 0; j < 9; ++j) {
				sudoku[i][j] = input.charAt(j) - '0';
			}
		}

		play(0, 0);

		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				sb.append(sudoku[i][j]);
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean play(int x, int y) {
		if (x == 9 && y == 0) {
			return true;
		}

		int[] next = next(x, y);
		if (sudoku[x][y] != 0) { // 이미 숫자가 있다면 다음칸으로 넘어가기
			if(play(next[0], next[1])) return true;
			else return false;
		}

		for (int num = 1; num <= 9; ++num) { // 숫자 채원 넣기
			if (okay(x, y, num)) {
				sudoku[x][y] = num;
				
				if(play(next[0], next[1])) return true;
				else sudoku[x][y] = 0;
			}
		}
		
		return false;
	}

	private static boolean okay(int x, int y, int num) {
		// 행 살피기
		for (int i = 0; i < 9; ++i) {
			if (sudoku[x][i] == num)
				return false;
		}
		// 열 살피기
		for (int i = 0; i < 9; ++i) {
			if (sudoku[i][y] == num)
				return false;
		}
		// 네모 살피기
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (sudoku[(x / 3) * 3 + i][(y / 3) * 3 + j] == num) return false;
			}
		}

		return true;
	}
	
	private static int[] next(int x, int y) {
		int nx = x;
		int ny = y + 1;
		if (ny == 9) {
			nx = x + 1;
			ny = 0;
		}
		
		return new int[] {nx, ny};
	}

}
