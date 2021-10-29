#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

#define NMAX 26

int N;
int map[NMAX][NMAX];
int visited[NMAX][NMAX];
int num_of_complex = 0; // 단지의 개수(1부터)
vector <int> num_of_house; // 각 단지에 집이 몇개인지
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

void DFS(int x, int y, int num_of_complex) {
	visited[x][y] = 1;
	num_of_house[num_of_complex]++;
	for (int i = 0; i < 4; ++i)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx >= 0 && ny >= 0 && nx < N && ny < N)
			if (map[nx][ny] == 1 && visited[nx][ny] == 0)
				DFS(nx, ny, num_of_complex);
	}
	
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> N;
	for (int i = 0; i < N; ++i) {
		string input;
		cin >> input;

		for (int j = 0; j < N; ++j)
			map[i][j] = input.at(j) - '0';
	}
	num_of_house.push_back(0);
	
	for (int i = 0; i < N; ++i)
		for (int j = 0; j < N; ++j)
			if (map[i][j] == 1 && visited[i][j] == 0) {
				num_of_house.push_back(0);
				DFS(i, j, ++num_of_complex);
			}

	sort(num_of_house.begin(), num_of_house.end());

	cout << num_of_complex << '\n';
	for (int i = 1; i <= num_of_complex; ++i)
		cout << num_of_house[i] << '\n';

	return 0;

}
