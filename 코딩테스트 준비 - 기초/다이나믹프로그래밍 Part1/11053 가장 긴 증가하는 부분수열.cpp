#include <iostream>
#include <vector>
using namespace std;

int DP[1000];

int main() {
	int N;
	cin >> N;

	vector<int> A(N, 1);
	int ans = 1;
	for (int i = 0; i < N; ++i) cin >> A[i];

	for (int i = 0; i < N; ++i) DP[i] = 1;

	for (int i = 0; i < N; ++i)
		for (int j = 0; j < i; ++j)
			if (A[j] < A[i] && DP[j] >= DP[i]) DP[i] = DP[j] + 1;

	/* DP의 최대값 찾기 */
	for (int i = 0; i < N; ++i)
		if (ans < DP[i]) ans = DP[i];

	cout << ans;
	return 0;
}
