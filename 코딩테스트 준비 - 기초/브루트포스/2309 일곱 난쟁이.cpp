#include <iostream>
#include <algorithm>
using namespace std;

int dwarf[9];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);


	int sum_of_ninedwarf = 0;
	int sum_of_sevendwarf;

	for (int i = 0; i < 9; ++i)
	{
		cin >> dwarf[i];
		sum_of_ninedwarf += dwarf[i];
	}

	sort(dwarf, dwarf + 9);
	for (int pick1 = 0; pick1 < 8; ++pick1)
	{
		for (int pick2 = pick1 + 1; pick2 < 9; ++pick2)
		{
			sum_of_sevendwarf = sum_of_ninedwarf - dwarf[pick1] - dwarf[pick2];
			if (sum_of_sevendwarf == 100)
			{
				for (int i = 0; i < 9; ++i)
					if (i != pick1 && i != pick2) cout << dwarf[i] << '\n';
				return 0;
			}
		}
	}


	return 0;
}

/* 아이디어 */
// 아홉난쟁이의 합에서 두 난쟁이를 선택해 빼기
