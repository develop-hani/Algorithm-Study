# programmers 평균 일일 대여 요금 구하기

[programmers 평균 일일 대여 요금 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/151136)

### 🤔 문제 이해하기

CAR_RENTAL_COMPANY_CAR에는 다음과 같은 속성이 있다.
|Column name|Type|Nullable|
|---|---|---|
|CAR_ID|INTEGER|FALSE|
|CAR_TYPE|VARCHAR(255)|FALSE|
|DAILY_FEE|INTEGER|FALSE|
|OPTIONS|VARCHAR(255)|FALSE|

</br>

CAR_RENTAL_COMPANY_CAR 테이블에서 자동차 종류가 'SUV'인 자동차들의 평균 일일 대여 요금을 출력하는 SQL문을 작성해주세요. 이때 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림하고, 컬럼명은 AVERAGE_FEE 로 지정해주세요.

### 💻 문제를 해결한 코드

```java
SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV';
```
