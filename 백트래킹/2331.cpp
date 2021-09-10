#include <iostream>
#include <string>
using namespace std;

int N;
string ans = " ";

bool IsPromising(string progression)
{
	for (int i = 1; i <= progression.length() / 2; ++i) // i길이의 문자열 비교
	{
		for (int j = 0; j < i; ++j)
		{

		}
	}
	return true;
}

void backtracking(string progression, int figure)
{
	if (figure = N) return; // N자릿수 수열이 완성되면 return
	else
	{
		if (IsPromising(progression))
		{
			backtracking(progression + "1", figure + 1);
			backtracking(progression + "2", figure + 1);
			backtracking(progression + "3", figure + 1);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N;

	backtracking(ans, 0);

	cout << ans;
	return 0;
}
