#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int E, S, M; // 문제에서 주어진 수
	int year = 1;
	int E_check, S_check, M_check; //1 씩 늘려가며 확인해볼 수
	E_check = 1; S_check = 1; M_check = 1;

	cin >> E >> S >> M;

	while (1)
	{	
		if (E == E_check && S == S_check && M == M_check)
		{
			cout << year;
			return 0;
		}
		E_check++; S_check++; M_check++;
		if (E_check == 16) E_check = 1;
		if (S_check == 29) S_check = 1;
		if (M_check == 20) M_check = 1;
		year++;
	}
}
