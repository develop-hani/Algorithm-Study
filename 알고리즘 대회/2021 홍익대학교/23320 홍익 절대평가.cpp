#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	int score[100];
	int X, Y;
	int num_of_A = 0;
	
	cin >> N;
	for (int i = 0; i < N; ++i) cin >> score[i];
	cin >> X >> Y;

	for (int i = 0; i < N; ++i) {
		if (score[i] >= Y) num_of_A++;
	}

	cout << N * X / 100 << " " << num_of_A;

	return 0;
}
