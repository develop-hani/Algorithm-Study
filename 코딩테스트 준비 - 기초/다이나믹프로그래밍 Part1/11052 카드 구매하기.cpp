#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int N; // 민규가 구매하려고 하는 카드 수
	cin >> N;

	vector<int> P(N + 1); // N개의 카드가 들어있는 카드팩의 가격
	P[0] = 0; // P[0]은 쓰지 않으므로 아무 수나 입력한다.
	for (int i = 1; i <= N; ++i) cin >> P[i];

	vector<int> DP(N + 1); // N개의 카드를 갖기 위한 금액의 최댓값
	DP[0] = 0;

	DP[1] = P[1]; // 카드 1개를 갖기위해 지불해야하는 금액의 최댓값 = 카드 1개가 포함된 카드팩 가격
	for (int i = 2; i <= N; ++i)
		for (int j = 0; j <= i; ++j)
			DP[i] = max(DP[i], DP[j] + P[i - j]);

	cout << DP[N];
	return 0;
}
