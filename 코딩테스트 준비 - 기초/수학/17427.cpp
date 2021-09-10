#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N;
	long long ans = 0;
	
	cin >> N;

	for (int i = 1; i <= N; ++i) ans += i * (N / i);

	cout << ans;
	return 0;
}

/* 아이디어 */
// 1 ~ N까지 1을 약수로 가지는 수 N개
//           2를 약수로 가지는 수 N/2개
//            ....

// 자료의 범위를 잘 살펴보기
// int는 4byte 값인데 결과가 4byte보다 큰 경우가 있으므로 ans의 자료형으로 8byte long long 사용
