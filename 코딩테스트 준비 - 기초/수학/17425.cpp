#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int num_of_testcase;
	int N;
	long long ans;

	cin >> num_of_testcase;

	while (num_of_testcase--)
	{
		cin >> N;

		ans = 0;
		for (int i = 1; i <= N; ++i) ans += i * (N / i);
		cout << ans << "\n";
	}

	return 0;
}
