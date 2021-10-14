#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

#define NMAX 1000

vector<int> adj[NMAX + 1];
int visited[NMAX + 1];


void DFS(int pos) {
	cout << pos << ' ';
	visited[pos] = 1;

	for (int i = 0; i < adj[pos].size(); ++i)
	{
		int tmp = adj[pos][i];
		if (!visited[tmp]) DFS(tmp);
	}
		
}

void BFS(int pos)
{
	queue<int> q;
	q.push(pos);
	visited[pos] = 1;

	while (!q.empty())
	{
		/* q에서 하나의 원소를 뽑아 출력한다. */
		int now = q.front();
		q.pop();
		cout << now << ' ';

		/* 해당 노드에 인접하고 아직 방문하지 않은 원소들을 큐에 삽입한다. */
		for (int i = 0; i < adj[now].size(); ++i)
		{
			int tmp = adj[now][i];
			if (!visited[tmp])
			{
				q.push(tmp);
				visited[tmp] = 1;
			}
		}
	}
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int nodes, edges, startNode; // N: 정점의 수, M: 간선의 수, V: 탐색 시작할 정점
	cin >> nodes >> edges >> startNode;

	/* 인접행렬을 사용 */
	for (int i = 0; i < edges; ++i)
	{
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	for (int i = 1; i <= nodes; ++i)
		sort(adj[i].begin(), adj[i].end());

	DFS(startNode);
	cout << '\n';
	for (int i = 1; i <= nodes; ++i) visited[i] = 0;
	BFS(startNode);
	
	return 0;
}
