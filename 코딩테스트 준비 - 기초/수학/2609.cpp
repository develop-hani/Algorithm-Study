#include <iostream>
using namespace std;

int Getgcd(int a, int b)
{
	int c;
	while (b != 0)
	{
		c = a % b;
		a = b;
		b = c;
	}
	return a;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int input1, input2;
	int gcd, lcm;

	cin >> input1 >> input2;

	/* 최대 공약수 */
	gcd = Getgcd(input1, input2);

	/* 최소 공배수 */
	lcm = input1 * input2 / gcd;

	cout << gcd << "\n" << lcm;
	return 0;
}
