#include <iostream>
#include <vector>
#include <algorithm>
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

	sort(divisor.begin(), divisor.end());
	ans = divisor.front() * divisor.back();

	cout << ans;
	return 0;	
}

// ans = 가장 작은 약수 * 가장 큰 약수 
