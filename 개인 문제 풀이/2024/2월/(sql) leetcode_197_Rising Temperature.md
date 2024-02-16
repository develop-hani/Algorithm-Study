# Leetcde 197 Rising Temperature

[Leetcde 197 Rising Temperature](https://leetcode.com/problems/rising-temperature/description/?envType=study-plan-v2&envId=top-sql-50)

### 🤔 문제 이해하기

- id, recordDate, temperature가 있는 테이블이 있다.
- pk는 id이며 recordDate unique하다.
- 테이블에서 전날보다 온도가 상승한 모든 기록의 id를 찾아라.

### ⭐ 알고리즘

- self join

### 📖 스토리 라인

- datediff 함수를 이용하여 날짜가 하루 차이가 나는 데이터를 찾는다.

### 💻 문제를 해결한 코드

```java
SELECT w2.id AS Id
FROM Weather w1
JOIN Weather w2 ON DATEDIFF(w1.recordDate, w2.recordDate) = -1
WHERE w1.temperature < w2.temperature;
```
