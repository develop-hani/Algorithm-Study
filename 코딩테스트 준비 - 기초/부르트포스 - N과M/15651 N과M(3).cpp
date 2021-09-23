#include <iostream>
#include <vector>
using namespace std;

int N, M;
vector<int> v;
bool visited[8];

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

		v.push_back(i);
		backtracking(level + 1);
		v.pop_back();

	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N >> M;

	backtracking(0);
	
	return 0;
}

/* N과 M(1)과 다른 부분 */
// backtracking 함수에서 visited 조건이 사라짐
// 자연수가 중복되도 되므로 앞에 나온 수를 적어도 된다.
