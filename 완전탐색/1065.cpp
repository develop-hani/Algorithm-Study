#include <iostream>
using namespace std;

/* 한수인지 확인하는 함수 */
bool check(int a)
{
	if (a < 100) return true;
	else
	{
		int x, y, z;
		x = a / 100; // 100의 자리
		y = a % 100 / 10; // 10의 자리
		z = a % 10; // 1의 자리

		if (x - y == y - z) return true;
		else return false;
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int N;
	int cnt = 0; // 한수의 개수
	cin >> N; 

	for (int i = 1; i <= N; ++i)
	{
		if (check(i)) cnt++;
	}
	cout << cnt;
	return 0;
}
