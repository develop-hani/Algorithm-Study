#include <iostream>
using namespace std;

#define NMAX 1000000
#define mod 1000000009

long long DP[NMAX + 1] = { 0,1,2,4 };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int testcase;
	int n; int prevNMax = 3;
	
	cin >> testcase;

	while (testcase--) {
		cin >> n;
		
		if (n > prevNMax) { // 이전에 구한 적이 없다면
			for (int i = prevNMax + 1; i <= n; ++i)
				DP[i] = (DP[i - 1] + DP[i - 2] + DP[i - 3]) % mod;

			prevNMax = n;
		}

		cout << DP[n] << '\n';
	}
	return 0;
}
