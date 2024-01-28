# programmers / 가격대 별 상품 개수 구하기

[programmers / 가격대 별 상품 개수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/131530)

### 🤔 문제 이해하기

- 상품 아이디, 상품 코드, 가격이 있는 Product 테이블이 있다.
- 10,000원 단위로 각 가격대의 상품 개수를 구한다.

### ⭐ 알고리즘

- GROUP BY
- TRUNCATE

### 📖 스토리 라인

- Truncate을 이용하여 숫자를 적절히 내림한다.

### 💻 문제를 해결한 코드

```sql
SELECT TRUNCATE(PRICE / 10000, 0) * 10000 as PRICE_GROUP, COUNT(*)
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP asc;
```

```sql
SELECT TRUNCATE(PRICE, -4)  as PRICE_GROUP, COUNT(*)
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP asc;
```
