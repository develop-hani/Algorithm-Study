#include <iostream>
using namespace std;

int N;
int cnt = 0;
int board[15] = { 0 };

bool IsPromising(int row_check)
{
	for (int row_QueenExist = 0; row_QueenExist < row_check; ++row_QueenExist)
    // row_check이 현재 퀸을 두는 자리이고 row_check보다 큰 행에는 퀸이 존재하지 않으므로 확인하지 않아도 된다.
	{
		int col_check = board[row_check];
		int col_QueenExist = board[row_QueenExist];

    // 매번 다른 행을 확인하고 있으므로 같은 행에 있는 경우는 확인하지 않는다.
		if (col_QueenExist == col_check) return false; // 같은 열에 있는 경우
		else if (row_QueenExist - row_check == col_QueenExist - col_check || row_QueenExist - row_check == col_check - col_QueenExist) return false; // 같은 대각선에 있는 경우
	}
	return true;
}

void dfs(int row)
{
	/*모든 행에 하나씩, 총 N개의 Queen을 두는 방법 찾은 경우*/
	if (row == N)
	{
		cnt++;
	}
	else
	{
		for (int col = 0; col < N; ++col)
		{
			board[row] = col; // (row, col)에 퀸을 둔다.
			if (IsPromising(row)) dfs(row + 1); // (row, col)에 퀸을 둘 수 있다면 다음 행을 살펴본다.
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL); cout.tie(NULL);

	cnt = 0;
	cin >> N;

	dfs(0);

	cout << cnt << '\n';
	return 0;
}
