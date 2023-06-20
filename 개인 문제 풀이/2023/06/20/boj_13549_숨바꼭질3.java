import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 수빈 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        sb.append(find(n, k)).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int n, int k) {
        int[] time = new int[100001];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(n);
        time[n] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur * 2 < 100001 && time[cur * 2] == 0) {
                q.offer(cur * 2);
                time[cur * 2] = time[cur];
                if (cur * 2 == k) break;
            }
            if (cur - 1 >= 0 && time[cur - 1] == 0) {
                q.offer(cur - 1);
                time[cur - 1] = time[cur] + 1;
                if (cur - 1 == k) break;
            }
            if (cur + 1 < 100001 && time[cur + 1] == 0) {
                q.offer(cur + 1);
                time[cur + 1] = time[cur] + 1;
                if (cur + 1 == k) break;
            }
        }

        return time[k] - 1;
    }
}