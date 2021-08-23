#include <iostream>
#include <string>
using namespace std;

int main() {
	int cnt;
	char c;
	string str;

	while (1)
	{
		cnt = 0;
		cin >> c;
		if (c == '#') return 0;
		getline(cin, str);

		for (int i = 1; i < str.size(); i++)
		{
			if (str[i] == c || str[i] == c - 32) cnt++;
			// c는 항상 소문자이므로
			// str[i] == c; => 소문자와 같은 경우
			// str[i] == c - 32; => 대문자와 같은 경우
		}
		
		cout << c << ' ' << cnt << '\n';
	}
}

/* getline과 cin의 차이 */
// cin => 여백을 제외하고 저장
// getline => 여백까지 문자열로 저장, 개행문자 null로 저장
