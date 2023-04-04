/*
 * kmp 알고리즘을 이용하여 해결하였다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main_1786_찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// 입력
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();

		int tLen = text.length;
		int pLen = pattern.length;

		// 실패 함수 테이블
		int[] fail = new int[pLen];
		for (int i = 1, j = 0; i < pLen; ++i) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = fail[j - 1];
			}
			if (pattern[i] == pattern[j]) {
				fail[i] = ++j;
			}
		}

		// 본문 패턴과 비교하기
		int j = 0;
		
		int cnt = 0; // 일치하는 문자의 수
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < tLen; ++i) {
			while (j > 0 && text[i] != pattern[j]) { // 일치하지 않음
				j = fail[j - 1];
			}

			if (text[i] == pattern[j]) { // 일치함
				if (j == pLen - 1) { // 완전히 일치하는 문자열
					++cnt;
					list.add(i - j + 1);
					j = fail[j];
				} else {
					++j;
				}
			}
		}
		
		sb.append(cnt).append("\n");
		for(int i = 0; i < cnt; ++i) {
			sb.append(list.get(i)).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
