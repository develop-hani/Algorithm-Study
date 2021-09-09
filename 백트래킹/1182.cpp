#include <iostream>
#include <vector>
using namespace std;


int N, S;
int cnt = 0;
vector<int> nums;

void dfs(int index, int sum)
{
	if (index == N) return;
	if (sum + nums[index] == S) cnt++; // 지금까지 더한게 S와 같다면

	dfs(index + 1, sum); // 현재 원소를 합에 추가하지 않는 경우
	dfs(index + 1, sum + nums[index]); // 현재 원소를 합에 추가하는 경우
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N >> S;
	for (int i = 0; i < N; ++i)
	{
		int tmp;
		cin >> tmp;
		nums.push_back(tmp);
	}

	dfs(0, 0);

	cout << cnt;
	return 0;
}
