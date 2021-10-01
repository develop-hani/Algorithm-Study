#include <iostream>
using namespace std;

#define N_MAX 15
#define T_MAX 5
int DP[N_MAX + T_MAX + 1]; // i번째 일까지 일했을 때 받을 수 있는 최대 금액
int T[N_MAX + 1];
int P[N_MAX + 1];

int main() {
	int N; // 퇴사일

	cin >> N;
	for (int i = 1; i <= N; ++i) cin >> T[i] >> P[i];

	for (int i = 1; i <= N; ++i)
	{
		if (DP[i + T[i]] < DP[i] + P[i]) DP[i + T[i]] = DP[i] + P[i];
		if (DP[i + 1] < DP[i]) DP[i + 1] = DP[i];
	}
	
	cout << DP[N + 1];
	return 0;
}
