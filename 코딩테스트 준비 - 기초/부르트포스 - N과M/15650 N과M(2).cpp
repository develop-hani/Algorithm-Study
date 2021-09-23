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
		if (!visited[i]) {
			if(v.empty()||i>v.back())
			{
				visited[i] = true;
				v.push_back(i);
				backtracking(level + 1);
				v.pop_back();
				visited[i] = false;
			}
		}
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
// 21행
// 벡터가 비어있거나 현재 탐색하는 부분이 벡터 이전 값보다 클 때 다음 과정을 탐색한다.
