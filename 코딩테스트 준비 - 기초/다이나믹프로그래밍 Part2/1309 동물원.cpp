#include <iostream>
using namespace std;

#define mod 9901
#define NMAX 100000
long long DP[NMAX][3] = { 0 };


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N;
	int ans;

	// 입력 및 초기화
	cin >> N;
	DP[0][0] = DP[0][1] = DP[0][2] = 1;

	// 문제 풀기
	for (int i = 1; i < N; ++i) {
		DP[i][0] = (DP[i - 1][0] + DP[i - 1][1] + DP[i - 1][2]) % mod;
		DP[i][1] = (DP[i - 1][0] + DP[i - 1][2]) % mod;
		DP[i][2] = (DP[i - 1][0] + DP[i - 1][1]) % mod;
	}
	ans = (DP[N - 1][0] + DP[N - 1][1] + DP[N - 1][2]) % mod;

	cout << ans;

	return 0;
}
