#include <iostream>
#include <queue>
using namespace std;

#define MAX 100

int N, M;
int maze[MAX + 1][MAX + 1] = { 0 }; // 0이 아닌 각 위치에 도달해는 최소횟수
int visited[MAX + 1][MAX + 1] = { 0 };
int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };
queue<pair<int, int>> q;

void BFS(int x, int y) {
	visited[x][y] = 1;
	maze[x][y] = 1;
	q.push(make_pair(x, y));

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < M ){
				if (visited[nx][ny] == 0 && maze[nx][ny] > 0) {
					visited[nx][ny] = 1;
					q.push(make_pair(nx, ny));
					maze[nx][ny] = maze[x][y] + 1;
				}
			}
		}
	}
}
int main(void) {
	cin >> N >> M;
	for (int i = 0; i < N; ++i) 
		for (int j = 0; j < M; ++j)
			scanf("%1d", &maze[i][j]);

	BFS(0, 0);

	cout << maze[N - 1][M - 1];

	return 0;
}
