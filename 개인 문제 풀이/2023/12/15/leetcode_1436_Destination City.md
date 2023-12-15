# LEETCODE 1436번 Destination City

[LEETCODE 1436번 Destination City](https://leetcode.com/problems/destination-city/description/?envType=daily-question&envId=2023-12-15)

### 🤔 문제 이해하기

1. 도시A와 도시B로 향하는 경로가 주어진 list가 있다.
2. 임의의 도시에서 출발할 때, 도착하는 도시를 찾아라

### 💻 문제를 해결한 코드

```java
class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> cities = new HashMap<>();

        // 출발지를 key, 도착지를 value로하는 map에 경로 넣기
        for (int i = 0; i < paths.size(); ++i) {
            cities.put(paths.get(i).get(0), paths.get(i).get(1);
        }

        // 행선지가 없는 경로가 나올 때까지 탐색
        String from = paths.get(0).get(0);
        while(cities.containsKey(from)) {
            from = cities.get(from); // from의 도착지가 다음 출발지
        }

        return from;
    }
}
```
