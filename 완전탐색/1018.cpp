#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL); cout.tie(NULL);

	string StartWithWhite[8] =
	{
		{"WBWBWBWB"},
		{"BWBWBWBW"},
		{"WBWBWBWB"},
		{"BWBWBWBW"},
		{"WBWBWBWB"},
		{"BWBWBWBW"},
		{"WBWBWBWB"},
		{"BWBWBWBW"}
	};

	string StartWithBlack[8] =
	{
		{"BWBWBWBW"},
		{"WBWBWBWB"},
		{"BWBWBWBW"},
		{"WBWBWBWB"},
		{"BWBWBWBW"},
		{"WBWBWBWB"},
		{"BWBWBWBW"},
		{"WBWBWBWB"}
	};

	int N, M;
	cin >> N >> M;

	char** board = new char* [N];
	for (int i = 0; i < N; ++i) board[i] = new char[M];
	for (int i = 0; i < N; ++i)
	{
		for (int j = 0; j < M; ++j)
			cin >> board[i][j];
	}

	int min = 300;
	int min_StartWithWhite, min_StartWithBlack;
	int tmp;

	for (int a = 0; a + 8 <= N; ++a)
	{
		for (int b = 0; b + 8 <= M; ++b)
		{
			min_StartWithWhite = 0; min_StartWithBlack = 0;
			for (int i = 0; i < 8; ++i)
			{
				for (int j = 0; j < 8; ++j)
				{

					if (StartWithWhite[i][j] != board[a + i][b + j]) min_StartWithWhite++;
					if (StartWithBlack[i][j] != board[a + i][b + j]) min_StartWithBlack++;
				}
			}
			tmp = (min_StartWithWhite > min_StartWithBlack) ? min_StartWithBlack : min_StartWithWhite;
			min = (min > tmp) ? tmp : min;
		}
	}
	cout << min;
	return 0;
}
