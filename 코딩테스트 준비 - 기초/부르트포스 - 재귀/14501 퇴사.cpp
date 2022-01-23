#include <iostream>
using namespace std;

#define N_MAX 15
int N, ans = 0;
int T[N_MAX + 1];
int P[N_MAX + 1];

void recursive(int day, int pay) {
	// 퇴사일 이후까지 진행해야하는 상당인 경우
	if(day > N + 1) return;

	// 퇴사일까지 상담을 진행한 경우(결과 도출)
	if (day == N + 1) {
		if (ans < pay) ans = pay;
		return;
	}

	// 재귀함수 부르기
	recursive(day + T[day], pay + P[day]); // 상담을 진행한 경우
	recursive(day + 1, pay); // 상담을 진행하지 않은 경우

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N;
	for (int i = 1; i <= N; ++i) cin >> T[i] >> P[i];

	recursive(1, 0);

	cout << ans;
	return 0;
}
