#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 10
int N, M, K;
int max_until_now = -40000;
int board[MAX][MAX];
bool visited[MAX][MAX];
int check;

void backtracking(int cnt, int sum)
{
	if (cnt == K)
	{
		max_until_now = max(max_until_now, sum);
		check = max_until_now;
		return;
	}
	for (int i = 0; i < N; ++i)
		for (int j = 0; j < M; ++j)
		{
			if (!visited[i][j])
			{
				/* 현재 위치한 칸과 인접한 칸은 탐색하지 않도록 하기*/
				visited[i][j] = true;
				if (i - 1 > -1) visited[i - 1][j] = true; // 왼쪽칸
				if (i + 1 < N) visited[i + 1][j] = true; // 오른쪽칸
				if (j - 1 > -1) visited[i][j - 1] = true; // 위쪽칸
				if (j + 1 < M) visited[i][j + 1] = true; // 아래쪽칸

				backtracking(cnt + 1, sum + board[i][j]);

				/* 백트래킹이 끝나고 현재 칸과 인접한 칸이 다시 탐색되도록 하기 */
				visited[i][j] = false;
				if (i - 1 > -1) visited[i - 1][j] = false; // 왼쪽칸
				if (i + 1 < N) visited[i + 1][j] = false; // 오른쪽칸
				if (j - 1 > -1) visited[i][j - 1] = false; // 위쪽칸
				if (j + 1 < M) visited[i][j + 1] = false; // 아래쪽칸
			}
		}
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N >> M >> K;
	for (int i = 0; i < N; ++i)
		for (int j = 0; j < M; ++j)
			cin >> board[i][j];

	backtracking(0, 0);

	cout << max_until_now;

	return 0;
}
