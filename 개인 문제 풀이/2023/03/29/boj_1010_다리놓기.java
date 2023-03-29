/*
 * mCn 계산
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		while (--TC >= 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			bw.write(combination(n, m) + "\n");
		}

		bw.flush();
		br.close();
		br.close();
	}

	private static long combination(int n, int m) {
		int cnt = n > m - n ? m - n : n;
		long bunja = 1;
		long bunmo = 1;

		for (int i = 0; i < cnt; ++i) {
			bunja *= (m - i);
			bunmo *= (i + 1);
		}

		return bunja / bunmo;
	}

}