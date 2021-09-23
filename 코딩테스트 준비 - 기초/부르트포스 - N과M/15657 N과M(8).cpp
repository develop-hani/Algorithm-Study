#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
vector<int> input;
vector<int> v;

void backtracking(int level)
{
	if (level == M)
	{
		for (int i = 0; i < v.size(); ++i)
			cout << v[i] << ' ';
		cout << '\n';
		return;
	}
	for (int i = 1; i <= N; ++i)
	{
		if (v.empty() || input[i] >= v.back())
		{
			v.push_back(input[i]);
			backtracking(level + 1);
			v.pop_back();
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N >> M;
	input.push_back(0);
	for (int i = 0; i < N; ++i)
	{
		int tmp;
		cin >> tmp;
		input.push_back(tmp);
	}
	sort(input.begin(), input.end());

	backtracking(0);

	return 0;
}

/* 아이디어 */
// N과M(4)과 비슷하다고 생각해서 (4)의 알고리즘을 그대로 가져가고자 하였다.
// 하지만 visited를 i=1부터 탐색하므로
// 37행: input[0]에 가장 작은 값 0을 넣어 sort가 되더라도 영향을 미치지 않도록 하였다.
