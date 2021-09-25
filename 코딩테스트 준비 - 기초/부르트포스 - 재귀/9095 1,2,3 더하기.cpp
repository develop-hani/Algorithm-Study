#include <iostream>
using namespace std;

int addition[11] = { 0,1,2,4};

int solve(int n)
{
	if (addition[n]) return addition[n];
	else return addition[n] = solve(n - 1) + solve(n - 2) + solve(n - 3);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int T; // Testcase 수
	int n;

	cin >> T;

	solve(10); // 가능한 모든 n에 대해서 미리 구하여둠
	while (T--)
	{
		cin >> n;
		cout << addition[n] << '\n';
	}
	return 0;
}
