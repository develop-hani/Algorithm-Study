#include <iostream>
using namespace std;

int main() {
	int N, n = 0; // N 분해합, n 자릿수
	int sum; // sum 계산하여 구한 분해합
	cin >> N;

	/* N의 자릿수 구하기 */
	int cnt = N;
	while (cnt > 0)
	{
		cnt /= 10;
		n++;
	}

	for (int i = N - (n * 9); i < N; i++)
	{
		sum = i;
		cnt = i; //cnt 각 자리수의 합
		for (int j = n; j > 0; j--)
		{
			sum += cnt % 10;
			cnt /= 10;
		}
		if (sum == N) 
		{
			cout << i;
			return 0;
		}
	}

	cout << 0;
	return 0;
}


/* 아이디어 */
// 생성자는 항상 분해합보다 작다.
// 생성자의 범위를 생각해 보았을 때,
// 생성자가 가장 가장 작은 경우는 모든 자릿수가 9인 경우
// 생성자가 가장 큰 경우는 모든 자릿수의 합이 1인 경우이다.
// 따라서 분해합 N이 주어졌을 때, N의 자릿수를 n이라고 하면
// N - (n * 9)부터 N - 1까지를 조사하여 최소 생성자를 찾을 수 있다.
