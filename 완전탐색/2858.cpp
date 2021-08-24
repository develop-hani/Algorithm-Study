#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int R, B;
	int L, W;

	cin >> R >> B;

	for (int i = 3; 1; ++i)
	{
		for (int j = i; j >= 3; --j)
		{
			if (R + B == i * j && B == (i - 2) * (j - 2))
			{
				L = i;
				W = j;
				cout << L << ' ' << W << '\n';
				return 0;
			}
		}
	}
}



/* 아이디어 */
// 빨간타일 + 갈색타일 = 가로길이 * 세로길이
// 갈색타일 = (가로길이 - 2) * (세로길이 - 2)
