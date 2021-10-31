#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, K;
	cin >> N >> K;

	vector<int> a(N + 1);
	a[0] = 0;
	for (int i = 1; i <= N; ++i) cin >> a[i];

	int candy = 0;
	int day = 0;

	for (int i = K + 1; i <= N; ++i) {
		while (1) {
			if (a[i] != a[i - K]) {
				day++;
				candy = candy + a[i] - a[i - K];
				a[i] = a[i - K];
				sort(a.begin(), a.end());
			}
			else break;
		}

	}

	cout << candy << " " << day;
	return 0;
}
