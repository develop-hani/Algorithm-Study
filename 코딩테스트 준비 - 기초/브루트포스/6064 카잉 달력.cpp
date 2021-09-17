#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int T; // Testcase 수
	int M, N; // 카잉달력의 마지막 해
	int x, y; // 확인할 연도
	int x_check, y_check; // 직접 계산해볼 연도
	int year;

	cin >> T;

	while(T--)
	{
		cin >> M >> N >> x >> y;
		x_check = 1; y_check = 1;
		year = 1;
		
		while (1)
		{
			if (x == x_check && y == y_check)
			{
				cout << year << '\n';
				break;
			}
			if (x_check == M && y_check == N)
			{
				cout << -1 << '\n';
				break;
			}
			if (x_check > M) x_check = 1;
			if (y_check > N)y_check = 1;
			x_check++; y_check++;
			year++;
		}
	}
	return 0;
}
