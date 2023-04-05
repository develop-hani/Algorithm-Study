/*
 * 슬라이딩 윈도우를 활용하여
 * 기존 부분에서 변경이 생긴 부분들만 업데이트하며 문제를 풀이하였다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {
	
	static int[] belt, sushi; // belt: 벨트 위에 놓인 초밥, sushi: 초밥의 종류

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // n: 접시의 수
		int d = Integer.parseInt(st.nextToken()); // d: 초밥의 가지 수
		int k = Integer.parseInt(st.nextToken()); // k: 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // c: 쿠폰 번호

		belt = new int[n];
		sushi = new int[d + 1];
		int max = 0, cnt = 1;
		
		for(int i = 0; i < n; ++i) belt[i] = Integer.parseInt(br.readLine());
		sushi[c] = 1; // c는 항상 먹는 초밥
		
		// 로직
		for(int i = 0; i < k; ++i) { // 초기 k개 스시
			if(sushi[belt[i]]++ == 0) ++cnt;
			if(cnt > max) max = cnt;
		}
		
		for(int i = 0; i < n - 1; ++i) {
			if(--sushi[belt[i]] == 0) --cnt;
			if(sushi[belt[(i+k)%n]]++ == 0) ++cnt;
			if(cnt > max) max = cnt;
			if(max == k + 1) break;
		}
		
		// 출력
		sb.append(max).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
