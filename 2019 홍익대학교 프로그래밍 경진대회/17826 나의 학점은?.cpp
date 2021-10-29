#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int score[50];
	int hongikScore;
	int rank;

	for (int i = 0; i < 50; ++i) cin >> score[i];
	cin >> hongikScore;

	sort(score, score + 50);

	for (int i = 0; i < 50; ++i)
		if (hongikScore == score[i]) rank = 50 - i;

	if (1 <= rank && rank <= 5) cout << "A+";
	else if(6 <= rank && rank <= 15) cout << "A0";
	else if (16 <= rank && rank <= 30) cout << "B+";
	else if (31 <= rank && rank <= 35) cout << "B0";
	else if (36 <= rank && rank <= 45) cout << "C+";
	else if (46 <= rank && rank <= 48) cout << "C0";
	else cout << "F";

	return 0;
}
