#include <iostream>
#include <queue>
using namespace std;

int visited[100001];
int dist[100001]; // 얼마만큼 걸려서 갔는지 표시

void BFS(int pos) {
	queue<int> q;
	q.push(pos);
	visited[pos] = 1;

	while (!q.empty()) {
		int current_pos = q.front();
		q.pop();

		if ((current_pos - 1 >= 0) && (visited[current_pos - 1] == false)) {
			q.push(current_pos - 1);
			visited[current_pos - 1] = true;
			dist[current_pos - 1] = dist[current_pos] + 1;

		}
		if ((current_pos + 1 <= 100000) && (visited[current_pos + 1] == false)) {
			q.push(current_pos + 1);
			visited[current_pos + 1] = true;
			dist[current_pos + 1] = dist[current_pos] + 1;
		}
		if ((current_pos * 2 <= 100000) && (visited[current_pos * 2] == false)) {
			q.push(current_pos * 2);
			visited[current_pos * 2] = true;
			dist[current_pos * 2] = dist[current_pos] + 1;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, K;
	cin >> N >> K;

	visited[N] = 1;
	dist[N] = 0;

	BFS(N);

	cout << dist[K];
	return 0;
}
