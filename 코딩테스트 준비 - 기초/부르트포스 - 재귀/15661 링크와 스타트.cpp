#include <iostream>
#include <cmath>
using namespace std;

#define N_MAX 20
int S[N_MAX][N_MAX];
int teams[N_MAX]; // 1이면 team1, 0이면 team2
int N;
int team1Sum, team2Sum;
int diff;
int minOfDiff = 1000000;

void recursive(int idx) {
	if (idx == N) {
		team1Sum = 0; team2Sum = 0;
		for (int i = 0; i < N - 1; ++i) {
			for (int j = i; j < N; ++j) {
				if (teams[i] && teams[j])
					team1Sum += S[i][j] + S[j][i];
				else if(!teams[i] && !teams[j])
					team2Sum += S[i][j] + S[j][i];
			}
		}
		diff = abs(team1Sum - team2Sum);
		if (diff < minOfDiff) minOfDiff = diff;

		return;
	}
	teams[idx] = 1;
	recursive(idx + 1);
	teams[idx] = 0;
	recursive(idx + 1);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			cin >> S[i][j];
		}
	}

	recursive(0);

	cout << minOfDiff;
	return 0;
}
