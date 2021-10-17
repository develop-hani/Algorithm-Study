#include <iostream>
using namespace std;

#define NMAX 100000
int DP[NMAX + 1];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N;
	cin >> N;

	for (int i = 1; i <= N; ++i) {
		DP[i] = i;
		for (int j = 1; j * j <= i; ++j)
			if (DP[i] > DP[i - j * j] + 1)
				DP[i] = DP[i - j * j] + 1;
	}
	cout << DP[N];
	return 0;
}
