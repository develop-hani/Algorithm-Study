/*
 * dp를 이용하여 해결하였다.
 * 이전에는 원소가 들어갈 위치를 for문을 이용해 일일이 탐색했는데,
 * 이번에는 이분 탐색을 사용하여 원소가 들어갈 위치를 확인했다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; ++tc) {
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());

			sb.append(String.format("#%d %d\n", tc, lis(n, arr)));
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int lis(int n, int[] arr) {
		int idx = 0;
		int[] dp = new int[n];
		dp[0] = arr[0];

		for (int i = 1; i < n; ++i) {
			if (dp[idx] < arr[i]) dp[++idx] = arr[i];
			else dp[binarySearch(idx, dp, arr[i])] = arr[i];
		}

		return idx + 1;
	}
	
	private static int binarySearch(int len, int[] arr, int target) {
		int start = 0, end = len;
		
		int middle = (start + end) / 2;
		while(start < end) {
			if(arr[middle] == target) return middle;
			else if(arr[middle] < target) start = middle + 1;
			else end = middle - 1;
			
			middle = (start + end) / 2;
		}
		
		if(arr[middle] < target) return middle + 1;
		else return middle;
	}

}
