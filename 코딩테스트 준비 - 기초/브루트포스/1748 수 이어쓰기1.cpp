#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int N;
	unsigned int digit = 0; // 자릿수

	cin >> N;

	while (N)
	{
		digit += to_string(N).size();
		N--;
	}

	cout << digit;
	return 0;
}
