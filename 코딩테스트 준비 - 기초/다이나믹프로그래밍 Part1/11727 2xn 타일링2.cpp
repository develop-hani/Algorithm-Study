#include <iostream>
using namespace std;

int ways[1001] = { 0,1,3 };

int DP(int n) {
	if (ways[n]) return ways[n];
	else return ways[n] = (DP(n - 1) + 2 * DP(n - 2)) % 10007;
}

int main() {
	int n;

	cin >> n;

	cout << DP(n);
	return 0;
}
