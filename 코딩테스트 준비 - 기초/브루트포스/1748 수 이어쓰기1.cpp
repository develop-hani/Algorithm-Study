#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int N;
	unsigned int digit_of_num = 0; // 자릿수
	int cnt_digit = 1;

	cin >> N;

	while (cnt_digit <= N)
	{
		digit_of_num += (N - cnt_digit + 1);
		cnt_digit *= 10;
	}


	cout << digit_of_num;
	return 0;
}

/* 아이디어 */
// 1 ~ N까지의 수 중,
// 1의 자리를 가지고 있는 숫자의 수 = (N - 1 + 1)
// 10의 자리를 가지고 있는 숫자의 수 = (N - 10 + 1)
// 100의 자리를 가지고 있는 숫자의 수 = (N - 100 + 1)
