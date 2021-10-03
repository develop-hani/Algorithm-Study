#include <iostream>
using namespace std;

#define N_MAX 90
long long DP[N_MAX + 1] = { 0,1,1 };

int main() {
	int N;
	cin >> N;

	for (int i = 3; i <= N; ++i) DP[i] = DP[i - 1] + DP[i - 2];

	cout << DP[N] << '\n';
	return 0;
}
