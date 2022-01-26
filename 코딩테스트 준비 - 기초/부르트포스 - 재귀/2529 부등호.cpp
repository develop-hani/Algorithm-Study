#include <iostream>
using namespace std;

#define kMax 9

string operations[kMax];
bool numsUsed[10] = { false };
int value[kMax + 1] = { 0 };
int k;
long long maxNum = 0; // 숫자 비교를 위해 int로 정의
long long minNum = 9999999999;
string maxNumStr, minNumStr; // 제일 앞자리가 0인 경우를 위해 string으로 정의

void DFS(int idx) {
	// k+1자리의 정수를 구했을 때
	if (idx == k + 1) {
		long long curVal = 0;
		string curValStr = "";

		// value에 들어있는 숫자를 모아 정수 하나로 만들기
		for (int i = 0; i < k + 1; ++i) {
			curVal *= 10;
			curVal += value[i];
			curValStr += (char)value[i] + '0';
		}

		// maxNum과 minNum 갱신
		if (curVal > maxNum) {
			maxNum = curVal;
			maxNumStr = curValStr;
		}
		if (curVal < minNum) {
			minNum = curVal;
			minNumStr = curValStr;
		}

		return;
	}

	// 사용하지 않은 숫자를 찾아 i번째 자리 수 채우기
	for (int i = 0; i < 10; ++i) {
		if (numsUsed[i] == false) {
			if (idx > 0) {
				if (operations[idx - 1] == "<" && value[idx - 1] > i) continue;
				if (operations[idx - 1] == ">" && value[idx - 1] < i) continue;
			}
			numsUsed[i] = true;
			value[idx] = i;
			DFS(idx + 1);

			numsUsed[i] = false;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> k;
	for (int i = 0; i < k; ++i) cin >> operations[i];

	DFS(0);

	cout << maxNumStr << '\n' << minNumStr;
	return 0;
}
