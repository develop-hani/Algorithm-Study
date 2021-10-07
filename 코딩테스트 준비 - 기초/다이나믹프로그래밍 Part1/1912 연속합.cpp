#include <iostream>
#include <vector>
using namespace std;

#define max(A,B) A > B ? A : B
int DP[100000];

int main() {
	int n;
	cin >> n;

	vector<int> nums(n);
	for (int i = 0; i < n; ++i) cin >> nums[i];
	int ans = -1001;


	DP[0] = nums[0];
	for (int i = 1; i < n; ++i) DP[i] = max(DP[i - 1] + nums[i], nums[i]);

	/* DP의 최댓값 찾기 */
	for (int i = 0; i < n; ++i) ans = max(ans, DP[i]);

	cout << ans;
	return 0;
}
