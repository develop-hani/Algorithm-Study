#include <iostream>
using namespace std;

#define mod 1000000000
int DP[101][10];

int main() {
	int N;
	long long ans = 0;
	cin >> N;

	for (int i = 1; i <= 9; ++i) DP[1][i] = 1;

	for (int i = 2; i <= N; ++i)
		for (int j = 1; j < 9; ++j)
		{
			DP[i][0] = DP[i - 1][1] % mod;
			DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j + 1]) % mod;
			DP[i][9] = DP[i - 1][8] % mod;
		}
			

	for (int i = 0; i <= 9; ++i) ans += DP[N][i];

	cout << ans % mod << '\n';
	return 0;
}
