#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int N; // 민규가 구매하려고 하는 카드 수
	cin >> N;

	vector<int> P(N + 1); // N개의 카드가 들어있는 카드팩의 가격
	P[0] = 10001; // P[0]은 쓰지 않으므로 가장 큰 값을 입력한다.
	for (int i = 1; i <= N; ++i) cin >> P[i];

	vector<int> DP(N + 1); // N개의 카드를 갖기 위한 금액의 최솟값
	DP[0] = 0;
	for (int i = 1; i <= N; ++i) DP[i] = 10001; // 비교하면서 수를 줄여나가기 위해 초기에 큰 값을 넣어둔다.
	// vector <int> DP(n + 1,10001); 로 생성과 초기화를 동시에 할 수도 있다.

	DP[1] = P[1]; // 카드 1개를 갖기위해 지불해야하는 금액의 최댓값 = 카드 1개가 포함된 카드팩 가격
	for (int i = 2; i <= N; ++i)
		for (int j = 0; j < i; ++j)
			DP[i] = min(DP[i], DP[j] + P[i - j]);

	cout << DP[N];
	return 0;
}
