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
			cout << v[i] << " ";
		cout << '\n';
		return;
	}
	for (int i = 1; i <= N; ++i)
	{
		if (!visited[i]) {
			visited[i] = true;
			v.push_back(i);
			backtracking(level + 1);
			v.pop_back();
			visited[i] = false;
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
