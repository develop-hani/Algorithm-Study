# programmers / 2024 KAKAO WINTER INTERNSHIP / 도넛과 막대 그래프

[programmers / 2024 KAKAO WINTER INTERNSHIP / 도넛과 막대 그래프](https://school.programmers.co.kr/learn/courses/30/lessons/258711?language=java)

### 🤔 문제 이해하기

- 도넛 모양 그래프, 막대 모양 그래프, 8자 모양 그래프가 총 2개 이상 있다.
- 새로운 노드를 추가하고 각 그래프와 연결한다.
- 새로운 노드의 번호와 각 그래프의 개수를 찾는다.

### ⭐ 알고리즘

- 그래프 탐색

### 📖 스토리 라인

1. 각 노드의 진입 차수와 진출 차수를 구한다.
2. 새로운 노들를 찾는다.
   - 새로운 노드는 진출 차수가 2 이상이며 진입 차수가 0이다.
3. 새로운 노드로부터 연결된 노드를 탐색하며 그래프의 형태를 찾는다.

   - 진출 차수가 2 이상인 노드가 있다 => 8자 그래프
   - 시작 위치로 돌아온다 => 도넛
   - 사이클 없다 => 막대

   이 때, 8자 그래프도 시작 위치로 돌아올 수 있으므로 도넛 그래프보다 8자 그래프의 조건을 만족하는지 먼저 확인한다.

### 💻 문제를 해결한 코드

```java
import java.util.*;

class Solution {

    static int max = 1_000_001;
    static List<Integer>[] outEdge;
    static List<Integer>[] inEdge;

    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        getMax(edges);
        outEdge = new ArrayList[max];
        inEdge = new ArrayList[max];

        getOutEdge(edges);
        int newNode = findNewNode();
        answer[0] = newNode;

        for (int node : outEdge[newNode]) {
            answer[travel(node)] += 1;
        }

        return answer;
    }

    // 가장 큰 정점의 번호 찾기
    private static void getMax(int[][] edges) {
        for (int i = 0; i < edges.length; ++i) {
            max = Math.max(max, edges[i][0]);
            max = Math.max(max, edges[i][1]);
        }
        ++max;
    }

    // 각 노드의 진출 노드 연결
    private static void getOutEdge(int[][] edges) {
        for (int i = 0; i < max; ++i) {
            outEdge[i] = new ArrayList<>();
            inEdge[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; ++i) {
            int from = edges[i][0];
            int to = edges[i][1];

            outEdge[from].add(to);
            inEdge[to].add(from);
        }
    }

    // 진출 간선이 2개 이상, 진입 간선이 0개인 경우 새로 생성한 노드
     private static int findNewNode() {
         for (int i = 0; i < max; ++i) {
             if (outEdge[i].size() > 1 && inEdge[i].size() == 0) return i;
         }
         return -1;
     }

    // 도넛이면 1, 막대면 2, 8이면 3 반환
    // 그래프를 따라 이동할 때
    // 진출 차수가 2 이상인 노드가 있다 => 8자 그래프
    // 시작 위치로 돌아온다 => 도넛
    // 사이클 없다 => 막대
    private static int travel(int start) {
        try {
            int next = outEdge[start].get(0);
            while(true) {
                if (outEdge[next].size() == 2) return 3;
                if (next == start) return 1;
                next = outEdge[next].get(0);
            }
        } catch (Exception e) {
            return 2;
        }
    }
}
```
