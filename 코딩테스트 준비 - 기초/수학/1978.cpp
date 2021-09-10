#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N; // 주어질 숫자의 수
	int nums;
	cin >> N;
	int cnt = N;

	for (int i = 0; i < N; ++i)
	{
		cin >> nums;
		if (nums == 1) cnt--;
		for (int j = 2; j <= nums / 2; ++j)
		{
			if (nums % j == 0)
			{
				cnt--;
				break;
			}
		}
	}

	cout << cnt;
	return 0;
}

/* 아이디어 */
// 전체에서 소수가 아닌 것을 빼자
