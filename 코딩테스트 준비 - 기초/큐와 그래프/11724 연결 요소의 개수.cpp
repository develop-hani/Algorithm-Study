#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define NMAX 1000

vector<int> adj[NMAX + 1];
int visited[NMAX + 1];


void DFS(int pos) {
	visited[pos] = 1;

	for (int i = 0; i < adj[pos].size(); ++i)
	{
		int tmp = adj[pos][i];
		if (!visited[tmp]) DFS(tmp);
	}
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int cnt = 0;
	int nodes, edges; // N: 정점의 수, M: 간선의 수
	cin >> nodes >> edges;

	for (int i = 0; i < edges; ++i)
	{
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	for (int i = 1; i <= nodes; ++i)
		sort(adj[i].begin(), adj[i].end());

	for (int i = 1; i <= nodes; ++i) // 인접리스트를 확인한다.
	{
		if (visited[i] == 0) // 방문하지 않은 노드가 있을 때
		{
			DFS(i); // 그 노드의 연결 요소를 탐색하고
			cnt++; // 연결 요소 수를 1 증가시킨다.
		}
	}

	cout << cnt;
	
	return 0;
}
