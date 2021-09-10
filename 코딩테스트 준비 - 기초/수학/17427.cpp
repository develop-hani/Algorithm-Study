#include <iostream>
using namespace std;

int Sum_of_divisor(int x)
{
	int sum = 0;

	for (int i = 1; i <= x; ++i)
	{
		if (x % i == 0) sum += i;
	}
	return sum;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N;
	int ans = 0;
	
	cin >> N;

	for (int i = 1; i <= N; ++i) ans += Sum_of_divisor(i);

	cout << ans;
	return 0;
}
