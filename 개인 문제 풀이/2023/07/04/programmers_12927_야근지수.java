import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; ++i) pq.offer(works[i]);
        
        // 작업량 even하게 만들기
        int work = 0;
        while(n-- > 0) {
            work = pq.poll();
            if (work == 0) break;
            pq.offer(work - 1);
        }
        
        // 피로도 구하기
        long answer = 0;
        while(!pq.isEmpty()) {
            work = pq.poll();
            if(work == 0) break;
            answer += work * work;
        }   
        
        return answer;
    }
}