#include <iostream>
using namespace std;

#define mod 10007
#define NMAX 1000

int DP[NMAX + 1][10];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	// 선언, 입력 받기
	int N; cin >> N;
	int ans = 0;

	// 초기화
	
	for (int i = 0; i < 10; ++i) {
		DP[0][i] = 0;
		DP[1][i] = 1;
	}

	// 문제 풀기
	for (int i = 2; i <= N; ++i) {
		DP[i][0] = (DP[i - 1][0]) % mod;
		for (int j = 1; j < 10; ++j) {
			DP[i][j] = (DP[i - 1][j] + DP[i][j - 1]) % mod;
		}
	}

	for (int i = 0; i < 10; ++i) ans += DP[N][i];
	ans %= mod;

	cout << ans;

	return 0;
}
