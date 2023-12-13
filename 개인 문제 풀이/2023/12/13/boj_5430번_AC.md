# BOJ 54360번 AC

[BOJ 54360번 AC](https://www.acmicpc.net/problem/5430)

### 🤔 문제 이해하기

1. R과 D가 나열되는 있는 문자열이 있다.
2. 숫자로 이루어진 배열에 R, D의 순서에 맞추어 명령을 실행한다

### 💻 문제를 해결한 코드

front와 last에서 원소를 추가, 제거할 수 있는 자료구조인 Deque을 활용하였다.

```java
import java.io.*;
import java.util.*;

public class Main {

    static Deque<Integer> nums;
    static boolean firstIsFront;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            String order = br.readLine();
            int n = Integer.parseInt(br.readLine());
            getNums(n, br.readLine());

            boolean clear = doOrder(order);

            if (!clear) sb.append("error");
            else writeResult();
            if (TC > 0) sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // [1,2,3,4]에서 1,2,3,4를 덱에 넣기
    static void getNums(int n, String str) {
        nums = new LinkedList<>();
        str = str.substring(1, str.length() - 1);
        StringTokenizer st = new StringTokenizer(str, ",");
        for (int i = 0; i < n; ++i) {
            int num = Integer.parseInt(st.nextToken());
            nums.addLast(num);
        }
    }

    // 큐에 들어있는 숫자들을 order에 따라 실행하기
    static boolean doOrder(String order) {
        firstIsFront = true;
        for (int i = 0; i < order.length(); ++i) {
            char ord = order.charAt(i);
            if (ord == 'R') {
                firstIsFront = !firstIsFront;
            }
            else {
                if (nums.size() == 0) { // 더 이상 제거할 숫자가 없는 경우
                    return false;
                }
                if (firstIsFront) nums.pollFirst();
                else nums.pollLast();
            }
        }
        return true;
    }

    // 큐에 담겨 있는 결과를 형식에 맞추어 출력하기
    static void writeResult() {
        sb.append("[");
        if (firstIsFront) {
            while(!nums.isEmpty()) {
                sb.append(nums.pollFirst());
                if (!nums.isEmpty()) sb.append(",");
            }
        } else {
            while(!nums.isEmpty()) {
                sb.append(nums.pollLast());
                if (!nums.isEmpty()) sb.append(",");
            }
        }
        sb.append("]");
    }

}
```
