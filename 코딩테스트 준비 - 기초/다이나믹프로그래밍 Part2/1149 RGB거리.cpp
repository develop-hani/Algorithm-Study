#include <iostream>
using namespace std;

#define MIN(a, b) ((a < b) ? a : b)
#define NMAX 1000
int cost[NMAX][3] = { 0 };
int DP[NMAX][3] = { 0 };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N;
	int ans;

	// 입력받기
	cin >> N;
	for(int i=0;i<N;++i)
		for (int j = 0; j < 3; ++j) {
			cin >> cost[i][j];
		}

	// 문제 풀기
	for (int i = 0; i < N; ++i) {
		DP[i][0] = MIN(DP[i - 1][1], DP[i - 1][2]) + cost[i][0];
		DP[i][1] = MIN(DP[i - 1][0], DP[i - 1][2]) + cost[i][1];
		DP[i][2] = MIN(DP[i - 1][0], DP[i - 1][1]) + cost[i][2];
	}

	ans = MIN(DP[N - 1][0], DP[N - 1][1]);
	ans = MIN(ans, DP[N - 1][2]);

	cout << ans;

	return 0;
}
