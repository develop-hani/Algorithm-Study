#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N;
	int ans = 0;
	
	cin >> N;

	for (int i = 1; i <= N; ++i) ans += i * (N / i);

	cout << ans;
	return 0;
}

/* 아이디어 */
// 1 ~ N까지 1을 약수로 가지는 수 N개
//           2를 약수로 가지는 수 N/2개
//            ....
