import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    static int n, m, arr[];
    static LinkedHashSet<String> hs = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 정렬
        Arrays.sort(arr);

        // 숫자 선택
        combination(0, new int[m], new boolean[n]);

        // 출력
        for (String str : hs) {
            sb.append(str).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    //
    private static void combination(int idx, int[] selected, boolean[] visited) {
        if (idx == m) {
            String str = "";
            for (int i = 0; i < m; ++i) {
                str += Integer.toString(selected[i]) + " ";
            }
            hs.add(str);
            return;
        }

        for (int i = 0; i < n; ++i) {
            if(visited[i]) continue;
            selected[idx] = arr[i];
            visited[i] = true;
            combination(idx + 1, selected, visited);
            visited[i] = false;
        }
    }

}

