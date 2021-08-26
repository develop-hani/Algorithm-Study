#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL); cout.tie(NULL);

	int T, N, M; // 입력
	int cnt; // '0'의 수
	cin >> T;

	while (T--)
	{
		cnt = 0;
		cin >> N >> M;

		for (int i = N; i <= M; ++i)
		{
			int tmp = i;

			/* 주어진 숫자가 0일 경우 */
			if (tmp == 0) cnt++;

			/* 주어진 숫자가 0이 아닐 경우 */
			// 각 숫자를 쪼개서 0인지 아닌지 확인
			while (tmp != 0)
			{
				int check = tmp % 10;
				if (check == 0) cnt++;
				tmp /= 10;
			}
		}
		cout << cnt << '\n';
	}
	return 0;
}
