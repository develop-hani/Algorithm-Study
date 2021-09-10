#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int num_of_divisor;
	vector<int> divisor;
	int ans;

	cin >> num_of_divisor;
	for (int i = 0; i < num_of_divisor; ++i)
	{
		int tmp;
		cin >> tmp;
		divisor.push_back(tmp);
	}

	ans = divisor[0];
	for (int i = 1; i < num_of_divisor; ++i) ans *= divisor[i];

	cout << ans;
	return 0;	
}
