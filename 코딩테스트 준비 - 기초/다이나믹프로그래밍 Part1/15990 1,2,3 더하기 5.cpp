#include <iostream>
using namespace std;

#define mod 1000000009

long long num1[1000000 + 1];
long long num2[1000000 + 1];
long long num3[1000000 + 1];

int main() {
	int T; // Testcase 수
	int n;

	cin >> T;

	num1[1] = num2[2] = num3[3] = 1;
	num1[3] = num2[3] = 1;

	while (T--)
	{
		cin >> n;

		for (int i = 4; i <= n; ++i)
		{
			num1[i] = (num2[i - 1] + num3[i - 1]) % mod;
			num2[i] = (num1[i - 2] + num3[i - 2]) % mod;
			num3[i] = (num1[i - 3] + num2[i - 3]) % mod;
		}

		cout << (num1[n] + num2[n] + num3[n]) % mod << '\n';
		
    		 /* 초기화 */
		for (int i = 4; i <= n; ++i)
		{
			num1[i] = 0;
			num2[i] = 0;
			num3[i] = 0;
		}
	}
	return 0;
}
