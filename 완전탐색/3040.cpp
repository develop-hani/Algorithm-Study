#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL); cout.tie(NULL);

	int dwarf[9]; // 아홉 난쟁이 모자에 쓰여있는 수
	int sum; // 더해 볼 수

	for (int i = 0; i < 9; ++i) cin >> dwarf[i];

	/* 두 수 i, j를 제외한 일곱개의 숫자 더하기 */
	while (true)
	{
		for (int i = 0; i < 8; ++i)
		{
			for (int j = i + 1; j < 9; ++j)
			{
				sum = 0;
				for (int x = 0; x < 9; ++x)
				{
					if (x != i && x != j) sum += dwarf[x];
				}
				if (sum == 100)
				{
					for (int x = 0; x < 9; ++x)
					{
						if (x != i && x != j) cout << dwarf[x] << '\n';
					}
					return 0;
				}
			}
		}
	}
}
